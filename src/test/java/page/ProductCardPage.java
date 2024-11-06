package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProductCardPage {

    public static void startMakeOrder(){
         $(byText("Выбрать тему оформления")).click();
        //robot.click($(byText("Выбрать тему оформления")));
    }

    public static void chooseYourStyle(){
      //  robot.click($(byText("Ваш стиль")));
        $(byText("Ваш стиль")).click();
        Selenide.refresh();
    }

    public static void chooseYourStyleMaket(){
     //   robot.click($("div.open_style--js"));
         $("div.open_style--js").click();
    }

    public static void chooseLoveStyle(){
        $(byText("На свадьбу")).click();
        Selenide.refresh();
    }

    public static void chooseLoveStyleMaket(){
        $(byText("Love")).click();
    }

    public static void goToExpress(){
     //   robot.click($("li#editor_express", 1));
          $("li#editor_express", 1).click();
    }


}
