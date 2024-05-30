import ShopPages.SearchPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchResultTest extends BaseTest {
    SearchPage searchResultPage = new SearchPage();

    @BeforeMethod
    void beforeMethod() {
        open("/");
        searchResultPage.acceptCookie()
                .removeCountrySelect();
    }

    @Test(description = "Search recommended item test")
    void recommendedItemSearchTest() {
        searchResultPage.clickOnSearchIcon()
                .selectRecommendedProduct();
        Assert.assertTrue(searchResultPage.getSearchResultText().contains("SEARCH RESULTS FOR \"NIKE METCON\""));
    }

    @Test(description = "Search item by query")
    void successfulSearchTest() {
        searchResultPage.clickOnSearchIcon()
                .search("Adidas");
        Assert.assertTrue(searchResultPage.getSearchResultText().contains("SEARCH RESULTS FOR \"ADIDAS\""));
    }

    @Test(description = "Correct brand filter test")
    void successfulFilterTest() {
        open("wintersports/women/");
        searchResultPage.selectBrand()
                .searchByFilterAndClick("adidas");
        Assert.assertEquals(searchResultPage.getSearchPageBrand().text(), "ADIDAS");
    }
}