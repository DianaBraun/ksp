package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WishlistPage extends BasePage {

    private final SelenideElement removeElement = $("button > .product-block__remove-image");
    private final SelenideElement wishlistAmount = $(".wishlist__amount");
    private final SelenideElement removeText = $(".product-layer__text");

    public SelenideElement checkWishlistAmount() {
        wishlistAmount.should(Condition.exist);
        return wishlistAmount;
    }

    public WishlistPage removeItemFromWishlist() {
        removeElement.should(Condition.exist);
        removeElement.click();
        return this;
    }

    public SelenideElement removeText() {
        return removeText;
    }
}