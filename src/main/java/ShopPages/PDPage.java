package ShopPages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingDefaultMethod;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage {
    private final SelenideElement premiumButton = $(byXpath("//button[@class=\"premium-details__button\"]"));
    private final SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private final SelenideElement wishListButton = $(".js-miniwishlist");
    private final SelenideElement basketCount = $("#js_product_quantity");
    private final SelenideElement addToBasketButton = $(byXpath("//a[@class=\"add-to-cart test-add-to-cart-button animated-button animated-button--cart\"]"));

    public PDPage addProductToBasket() {
        actions().moveToElement(addToBasketButton).perform();
        addToBasketButton.click();
        return this;
    }

    public PDPage addToWishlist() {
        actions().moveToElement(pdpWishlistIcon).perform();
        pdpWishlistIcon.click();
        return this;
    }

    public WishlistPage goToWishlist() {
        wishListButton.click();
        return new WishlistPage();
    }

    public PDPage buyPremium() {
        premiumButton.click(usingDefaultMethod().timeout(Duration.ofSeconds(10)));
        return this;
    }

    public SelenideElement getBasketCount() {
        return basketCount;
    }
}
