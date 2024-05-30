package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private final SelenideElement searchField = $("#searchParamDesktop");
    private final SelenideElement searchIcon = $(".test-search-popup-button");
    private final SelenideElement cookiesPopup = $("#uc-btn-accept-banner");
    private final SelenideElement countryLayer = $("div.header-top-right__dropdown-hold--language");


    public BasePage acceptCookie() {
        cookiesPopup.should(Condition.exist);
        cookiesPopup.click();
        return this;
    }

    public SearchPage clickOnSearchIcon() {
        searchIcon.click();
        return new SearchPage();
    }

    public SearchPage search(String searchString) {
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }

    public SearchPage removeCountrySelect() {
        countryLayer.hover();
        return new SearchPage();
    }
}