package page;


import static page.ComponentPage.upload;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public static void goToCheckoutUnauth() {
        $("div.col-xs-12", 16).click();
    }


    public static void checkoutChoosePickUpPoint() {
        upload();
//        robot.click($("button.order-delivery-switch"));
//        robot.click($("button.btn-secondary"));
//        robot.click($("input.form-control"));
          $("button.order-delivery-switch").click();
          $("button.btn-secondary").click();
        $("input.form-control").setValue("Автотестов");
        $("input.form-control", 1).setValue("Тест");
        $("input.form-control", 4).setValue("9997777777");
      //  robot.click($("button.btn-default", 1));
       $("button.btn-default", 1).click();

    }

    public static void chooseCourierDelivery() {
        upload();
        $("div.order-delivery-tile", 1).click();
        $(byText("Курьером")).click();
        upload();
        $("span.selection", 1).click();
        $("input.select2-search__field").setValue("Академическая").pressEnter();
    }

    public static void createOrder() {
       // robot.click($(byText("Подтвердить заказ")));
         $(byText("Подтвердить заказ")).click();
    }

}
