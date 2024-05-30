package ShopPages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class SearchPage extends BasePage {

    private final SelenideElement searchResult = $("div > .search__headline");
    private final SelenideElement recommendedProduct = $x("(//a[@class='keywords__list-link']) [2]");
    private final SelenideElement searchPageResult = $x("(//a[@href=\"/brands/adidas/\"])[1]");
    private final SelenideElement brandFilter = $x("(//button[@class=\"search-filter__item-button\"])[1]");
    private final ElementsCollection selectedFilter = $$("strong.product-card__title");
    private final SelenideElement filterBrandInList = $x("(//div[@class=\"input-switcher__label\"])[2]");

    public String getSearchResultText(){
        return searchResult.text();
    }

    public SearchPage searchByFilterAndClick(String text) {
        selectedFilter.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .filter(Condition.text(text))
                .first()
                .click();
        return this;
    }

    public void selectRecommendedProduct() {
        recommendedProduct.click();
    }
    public SearchPage selectBrand() {
        brandFilter.click();
        filterBrandInList.click();
        return this;
    }

    public SelenideElement getSearchPageBrand(){
        return searchPageResult;
    }
}