package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    Logger logger = LoggerFactory.getLogger(BasePage.class);
    private final SelenideElement searchField = $("#searchParamDesktop");
    private final SelenideElement searchIcon = $(".test-search-popup-button");
    private final SelenideElement cookiesPopup = $("#uc-btn-accept-banner");
    private final SelenideElement countryLayer = $("#js_country-layer-close-icon");

    public void click(SelenideElement element) {
        element.click();
    }

    public BasePage acceptCookie() {
        cookiesPopup.should(Condition.exist);
        click(cookiesPopup);
        return this;
    }
    public SearchPage clickOnSearchIcon() {
        click(searchIcon);
        return new SearchPage();
    }
    public SearchPage search(String searchString) {
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }

    public SearchPage removeCountrySelect(){
        $("div.header-top-right__dropdown-hold--language").hover();
        $(".test-login-link").hover();
        return new SearchPage();
    }
}
