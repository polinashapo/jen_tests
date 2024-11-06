package page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class PaykeeperCheckPage {


    public static void paykeeperCheck() {
        $("div.info_wrap").shouldHave(text("Оплата по QR-коду"));
    }

}
