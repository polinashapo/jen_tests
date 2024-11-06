package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static page.ComponentPage.upload;

public class ExpressPage {

    public static void addPhotoInExpress(){
//        robot.click($("button.add-photo--js"));
//        robot.click($("a.porch-home-tile", 6));
        $("button.add-photo--js").click();
         $("a.porch-home-tile", 6).click();
    }

    public static void choosePhotoFromAlbumExpress() {
//        robot.click(  $("li.sly-tabs-list-item", 9));
//        robot.click($(byText("Тестовый альбом")));
//        robot.click($("img.porch-photo-item-image"));
//        upload();
//        robot.click($("i.material-icons", 10));


        // $("li.sly-tabs-list-item", 9).click();
        // $(byText("Тестовый альбом")).click();
        // $("img.porch-photo-item-image").click();
//        Selenide.sleep(2000);
//        $("i.material-icons", 10).click();
    }

    public static void addToCartFromExpress() {
        //  $("button.print-template--js").click();
        // $("button.continue--js", 1).click();
//        robot.click($("button.print-template--js"));
//        robot.click($("button.continue--js", 1));

    }

    public static void addToCartFromExpressNotAuth() {
        $("button.print-template--js").click();
        $("button.btn-control-success").click();

    }


    public static void basketGoToCheckout() {
//        robot.click($("button#checkoutButton"));
        // $("button#checkoutButton").click();
        // $("div.btn_default").click();
    }

}
