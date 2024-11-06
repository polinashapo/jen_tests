package page;

import com.codeborne.selenide.Selenide;
//import mess.RobotHelper;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AuthPage {
 //  static RobotHelper robot = new RobotHelper();

    public static void authorizeByToken() {
        $("span.top_block_ico", 9).click();
        localStorage().setItem("access_token", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm9qZWN0X2d1aWQiOiI1ZWJlOWFkNDlkMjM0ODY1NTk3ZDRhMTkyOGVhNTliZSIsInVzZXJfZ3VpZCI6IjkzMjA5MmNjZWU4MjQxMzI4ZDYxZTUxODdiYWIyOTA1IiwiY2xpZW50X2lkIjoiOTMyMDkyY2NlZTgyNDEzMjhkNjFlNTE4N2JhYjI5MDUiLCJleHAiOjE3MzI0NDYxNDh9.NO_yyGzYaiaA1Dqxau6MjO8BDAplWxPxQdhE5mUM__ZQa0S6LUX1r54y2oD4sY2xaSXxNiqi9s2MlaxgCyWUyWbRXZcthd2SFNB1D2CrDKb01WYdi__uczybwTGeXQDL_f8fgme1N0-tdtqbnfGf37mTSG0caXbAyN0RNHZZY4azdzLdGnYLfC6S8Yo8P0doppVDNXKhIqkeeF7p4sHdI-JkeYeZpiOU1TvIErW59dSIi8F_i1w-YY3kNO4N2gu4aubM81wJAi6CP0467Yko2a84JyCMpQCTxMw5lXw5IsFJZ9KxuaNXCjqLLXT_9xECNYiAWFfweC0joIBbY3ZNjA");
        localStorage().setItem("refresh_token", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm9qZWN0X2d1aWQiOiI1ZWJlOWFkNDlkMjM0ODY1NTk3ZDRhMTkyOGVhNTliZSIsInVzZXJfZ3VpZCI6IjkzMjA5MmNjZWU4MjQxMzI4ZDYxZTUxODdiYWIyOTA1IiwiY2xpZW50X2lkIjoiOTMyMDkyY2NlZTgyNDEzMjhkNjFlNTE4N2JhYjI5MDUiLCJleHAiOjE3MzUwMzgxNDh9.wZF_R-0oXRxgXb4qlEiU9n1sBDS94MierlkX5_NzaRbsqJCILRSKIaa-EcjFqKIreP6OVQeWAoE91Zu3FHFCXGe2pqgogpl7c_VO6cIqdvgG0UBKc5kA9ru_S7C_edBMBcMUni9x0jxE9r6HjruEPT1SQFqHsOj7o5fLfxnGR5NeaKrhCiuT88_t-GVlMSP2sF_ZeLg95qOeocyaJ4708BJxurh-95Z97TArXC-OXFMMSoq7lmk0MJj9KKcIoNFz63yZwj3MoL9wK5MrHfn0G9-07ubW3_I6tvckDqCpNWwQcocXr-WGQWTby18pRCHJfvfPi3uMrNtWMSruPtRvjQ");
        Selenide.sleep(1000);
        $(By.xpath(".//a[contains(@href, '/')]"));
        sleep(2000);
        $("div.Avatar-module_wrapper_zamC_").click();
       // robot.click($("div.Avatar-module_wrapper_zamC_"));
    }
}
