import ShopPages.SearchPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchResultTest extends BaseTest {
    SearchPage searchResultPage = new SearchPage();

    @Test(description = "Тест на коректний пошук рекомендованого товара")
    void recommendedItemSearchTest() {
        open("/");
        searchResultPage.acceptCookie()
                .removeCountrySelect()
                .clickOnSearchIcon()
                .selectRecommendedProduct();
        Assert.assertTrue(searchResultPage.getSearchResultText().contains("SEARCH RESULTS FOR \"NIKE METCON\""));
    }

    @Test(description = "Тест на коректний пошук довільного товара")
    void successfulSearchTest()  {
        open("/");
        searchResultPage.acceptCookie()
                .removeCountrySelect()
                .clickOnSearchIcon()
                .search("Adidas");
        Assert.assertTrue(searchResultPage.getSearchResultText().contains("SEARCH RESULTS FOR \"ADIDAS\""));
    }

    @Test(description = "Тест на коректний фільтр бренду adidas")
    void successfulFilterTest() {
        open("/wintersports/women/");
        searchResultPage.acceptCookie();
        searchResultPage.selectBrand()
                .searchByFilterAndClick("adidas");
        Assert.assertEquals(searchResultPage.getSearchPageBrand().text(), "ADIDAS");
    }
}
