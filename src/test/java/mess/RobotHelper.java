//package mess;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.SelenideElement;
//import org.openqa.selenium.interactions.Actions;
//// import io.qameta.allure.Step;
//
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.actions;
//import static java.time.Duration.ofSeconds;
//
//public  class RobotHelper {
//
//    private static final int DEFAULT_TIMEOUT = 10;
//
//
//    @Step("Wait until element is visible: {0}")
//    public void waitUntilElementVisible(SelenideElement element) {
//        element.shouldBe(Condition.visible, ofSeconds(DEFAULT_TIMEOUT));
//    }
//
//
//    @Step("Click on element: {0}")
//    public void click(SelenideElement element) {
//        waitUntilElementVisible(element);
//        element.click();
//    }
//
//
//    @Step("Drag element from {0} to {1} using Actions")
//    public void dragAndDropWithActions(SelenideElement source, SelenideElement target) {
//        Actions actions = new Actions(source.getWrappedDriver());
//        actions.clickAndHold(source)
//                .moveToElement(target)
//                .release()
//                .build()
//                .perform();
//    }
//
//
//    @Step("Enter text '{1}' into element: {0}")
//    public void enterText(SelenideElement element, String text) {
//        waitUntilElementVisible(element);
//        element.clear();
//        element.setValue(text);
//    }
//
//
//    @Step("Hover over element: {0}")
//    public void hover(SelenideElement element) {
//        waitUntilElementVisible(element);
//        element.hover();
//    }
//
//
//    @Step("Double-click on element: {0}")
//    public void doubleClick(SelenideElement element) {
//        waitUntilElementVisible(element);
//        element.doubleClick();
//    }
//
//
//    @Step("Right-click on element: {0}")
//    public void rightClick(SelenideElement element) {
//        waitUntilElementVisible(element);
//        actions().contextClick(element).perform();
//    }
//
//
//    @Step("Scroll to element and click: {0}")
//    public void scrollToAndClick(SelenideElement element) {
//        element.scrollTo().click();
//    }
//
//
//    @Step("Check if element is visible: {0}")
//    public boolean isElementVisible(SelenideElement element) {
//        return element.is(Condition.visible);
//    }
//
//
//
//    public SelenideElement getElement(String selector) {
//        return $(selector);
//    }
//}
