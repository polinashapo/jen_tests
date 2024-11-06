package testnp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class TestBase
      //  implements TestWatcher
{

    private static final String DEFAULT_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm9qZWN0X2d1aWQiOiI1ZWJlOWFkNDlkMjM0ODY1NTk3ZDRhMTkyOGVhNTliZSIsInVzZXJfZ3VpZCI6IjkzMjA5MmNjZWU4MjQxMzI4ZDYxZTUxODdiYWIyOTA1IiwiY2xpZW50X2lkIjoiOTMyMDkyY2NlZTgyNDEzMjhkNjFlNTE4N2JhYjI5MDUiLCJleHAiOjE3MzI0NDYxNDh9.NO_yyGzYaiaA1Dqxau6MjO8BDAplWxPxQdhE5mUM__ZQa0S6LUX1r54y2oD4sY2xaSXxNiqi9s2MlaxgCyWUyWbRXZcthd2SFNB1D2CrDKb01WYdi__uczybwTGeXQDL_f8fgme1N0-tdtqbnfGf37mTSG0caXbAyN0RNHZZY4azdzLdGnYLfC6S8Yo8P0doppVDNXKhIqkeeF7p4sHdI-JkeYeZpiOU1TvIErW59dSIi8F_i1w-YY3kNO4N2gu4aubM81wJAi6CP0467Yko2a84JyCMpQCTxMw5lXw5IsFJZ9KxuaNXCjqLLXT_9xECNYiAWFfweC0joIBbY3ZNjA";


    @BeforeEach
    public void beforeEach() {
        String env = System.getProperty("env", "test");
        switch (env) {
            case "staging":
                Configuration.baseUrl = "https://staging.netprint.ru/";
                break;
            case "production":
                Configuration.baseUrl = "https://netprint.ru/";
                break;
            default:
                Configuration.baseUrl = "https://netprint.ru/";
        }

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = Long.parseLong(System.getProperty("timeout", "10000"));

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        prefs.put("profile.default_content_setting_values.geolocation", 1);
        prefs.put("profile.default_content_setting_values.media_stream", 1);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        options.setExperimentalOption("prefs", prefs);

        if (System.getProperty("remote") != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setBrowserName(Configuration.browser);
            Configuration.remote = System.getProperty("remote");
            Configuration.browserCapabilities = capabilities;
        } else {
            Configuration.browserCapabilities = options;
        }

        open(Configuration.baseUrl);
        Selenide.refresh();
    }

    @AfterEach
    public void tearDown() {
        captureBrowserConsoleLogs();
        Selenide.closeWebDriver();
    }


    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot(context.getDisplayName());
    }


    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test passed: " + context.getDisplayName());
    }


    static void authorizationByToken() {
        String token = System.getProperty("userToken", DEFAULT_TOKEN); // Retrieve token from system property or default
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("Token", token, ".netprint.ru", "/", null));
        Selenide.refresh();
    }


    public static void clearCookies() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }


    public static void maximizeWindow() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    public static void captureBrowserConsoleLogs() {
        WebDriverRunner.getWebDriver().manage().logs().get("browser").getAll()
                .forEach(log -> System.out.println("Browser Console: " + log.getMessage()));
    }


    private void takeScreenshot(String testName) {
        byte[] screenshotBytes = Selenide.screenshot(OutputType.BYTES);
 //       Allure.addAttachment("Screenshot - " + testName, new ByteArrayInputStream(screenshotBytes));
    }

//    @Step("Record video on failure")
//    private void recordFailureVideo(String testName) {
//        // Assuming Allure video plugin or any other video recording plugin is set up
//        // This is pseudo-code; specific setup may vary by plugin used
//        byte[] videoBytes = /* method to get video bytes from plugin */;
//        Allure.addAttachment("Failure Video - " + testName, "video/mp4", new ByteArrayInputStream(videoBytes), "mp4");
//    }
}
