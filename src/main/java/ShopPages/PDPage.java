package ShopPages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.ClickOptions.usingDefaultMethod;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage{
    private final SelenideElement premiumButton = $(byXpath("//button[@class=\"premium-details__button\"]"));
    private final SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private final SelenideElement wishListButton = $(".js-miniwishlist");
    private final SelenideElement basketCount = $("#js_product_quantity");
    private final SelenideElement addToBasketButton = $(byXpath("//a[@class=\"add-to-cart test-add-to-cart-button animated-button animated-button--cart\"]"));

    public PDPage addProductToBasket() {
        actions().moveToElement(addToBasketButton).perform();
        click(addToBasketButton);
        logger.info("Added product to basket");
        return new PDPage();
    }
    public PDPage addToWishlist() {
        actions().moveToElement(pdpWishlistIcon).perform();
        click(pdpWishlistIcon);
        logger.info("Added product to wishlist");
        return new PDPage();
    }

    public WishlistPage goToWishlist(){
        click(wishListButton);
        return new WishlistPage();
    }

    public PDPage buyPremium() {
        premiumButton.click(usingDefaultMethod().timeout(Duration.ofSeconds(8)));
        return new PDPage();
    }
    public SelenideElement getBasketCount() {
        return basketCount;
    }
}
