import ShopPages.PDPage;
import ShopPages.WishlistPage;
import com.codeborne.selenide.Condition;
import helpers.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class WishlistTest extends BaseTest {
    PDPage pdPage = new PDPage();
    WishlistPage wishlistPage = new WishlistPage();

    @BeforeMethod
    void beforeTest() {
        open("/p/nike-fury-3.0-headband-REQNI00O000.html");
        pdPage.acceptCookie();
        pdPage.addToWishlist()
                .goToWishlist();
    }

    @Test(description = "Add to wishlist test")
    void addToWishlistTest() {
        wishlistPage.checkWishlistAmount();
        Assert.assertEquals(wishlistPage.checkWishlistAmount().text(), "1");
    }

    @Test(description = "Remove from wishlist test", retryAnalyzer = RetryAnalyzer.class)
    void removeFromWishlistTest() {
        wishlistPage.removeItemFromWishlist()
                .removeText().shouldHave(Condition.text("The article has been removed from your wishlist."));
        Assert.assertEquals(wishlistPage.removeText().text(), "The article has been removed from your wishlist.");
    }
}