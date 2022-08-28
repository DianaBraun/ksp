import ShopPages.PDPage;
import ShopPages.WishlistPage;
import com.codeborne.selenide.Condition;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class WishlistTest extends BaseTest {
    PDPage pdPage = new PDPage();
    WishlistPage wishlistPage = new WishlistPage();

    @Test(description = "Тест на коректний пошук довільного товара")
    void addToWishlistTest() {
        open("/p/nike-fury-3.0-headband-REQNI00O000.html");
        pdPage.acceptCookie();
        pdPage.addToWishlist()
                .goToWishlist()
                .checkWishlistAmount();
        Assert.assertEquals(wishlistPage.checkWishlistAmount().text(), "1");
    }

    @Test(description = "Тест на коректний пошук довільного товара", retryAnalyzer = RetryAnalyzer.class)
    void removeFromWishlistTest() {
        open("/p/nike-fury-3.0-headband-REQNI00O000.html");
        pdPage.acceptCookie();
        pdPage.addToWishlist()
                .goToWishlist();
        wishlistPage.removeItemFromWishlist()
                .removeText().shouldHave(Condition.text("The article has been removed from your wishlist."));
        Assert.assertEquals(wishlistPage.removeText().text(), "The article has been removed from your wishlist.");
    }
}
