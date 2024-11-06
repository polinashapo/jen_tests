package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
// import static page.AuthPage.robot;

public class MainMenuPage {

    public static void chooseMenuSection(String menuSec) {
        $(byText(menuSec)).hover();
        //robot.hover($(byText(menuSec)).hover());
        Selenide.$(byText(menuSec)).hover();

    }

    public static void chooseProductType(String productType){
        Selenide.refresh();
          $(byText(productType)).click();
       // robot.click($(byText(productType)));
    }

}
