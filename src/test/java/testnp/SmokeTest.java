package testnp;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static page.AuthPage.*;
import static page.CheckoutPage.*;
import static page.ExpressPage.*;
import static page.MainMenuPage.*;
import static page.OrderPage.*;
import static page.PaykeeperCheckPage.*;
import static page.ProductCardPage.*;

public class SmokeTest extends TestBase {

    String calendMenuSec = "Календари",
            souvenirsPhotoSec = "Фотографии",
            productPocketCalend = "Карманный календарик",
            productPoster = "Постеры";


    @Test
    @Tag("smoke")
    @DisplayName("Заказ постера: неавторизованный юзер")
    void posterOrderNotAuthorized() {
        chooseMenuSection(souvenirsPhotoSec);
        chooseProductType(productPoster);
        startMakeOrder();
        chooseLoveStyle();
        Selenide.refresh();
        chooseLoveStyleMaket();
        goToExpress();
        Selenide.refresh();
        addToCartFromExpressNotAuth();
        // goToCheckoutUnauth();
        // authorizeByToken();
    }

    @Test
    @DisplayName("Заказ карманного календарика: авторизованный юзер")
    void calendOrderAuthorised() {
        authorizeByToken();
        chooseMenuSection(calendMenuSec);
        chooseProductType(productPocketCalend);
        startMakeOrder();
        chooseYourStyle();
        Selenide.refresh();
        chooseYourStyleMaket();
        goToExpress();
        Selenide.refresh();
        addPhotoInExpress();
        choosePhotoFromAlbumExpress();
        addToCartFromExpress();
        basketGoToCheckout();
        checkoutChoosePickUpPoint();
        createOrder();
        paykeeperCheck();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Пополнение лицевого счёта в личном кабинете")
    void orderTopUpAccount() {
        authorizeByToken();
        chooseLoginIcon();
        chooseMyFinancesMenu();
        fillFinanceAccount("11");
    }

    @Test
    @Disabled("отключенн")
    @Tag("smoke")
    @DisplayName("Пополнение лицевого счёта в личном кабинете")
    void orderDisAccount() {
        authorizeByToken();
        chooseLoginIcon();
        chooseMyFinancesMenu();
        fillFinanceAccount("11");
    }


}
