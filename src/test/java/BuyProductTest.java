import ShopPages.CheckoutPage;
import ShopPages.LoginPage;
import ShopPages.PDPage;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.ConfigReader;
import helpers.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class BuyProductTest extends BaseTest {
    Faker faker = new Faker();
    PDPage pdPage = new PDPage();
    LoginPage authPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test(description = "Buy Premium membership Test")
    void buyPremiumTest() throws IOException {
        open("/premium-membership");
        checkoutPage.acceptCookie();
        pdPage.buyPremium()
                .getBasketCount().shouldHave(Condition.text("1"));
        open(ConfigReader.getCheckoutUrl());
        checkoutPage.getAddedPremium()
                .goToCheckout()
                .checkoutRegister("test", "test", faker.internet().emailAddress(), "19111994qQ!")
                .setPersonalDataForPremium()
                .setPaymentData()
                .pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }

    @Test(description = "Successful item purchase test", retryAnalyzer = RetryAnalyzer.class)
    void buyProductTest() throws IOException {
        open("/p/nike-fury-3.0-headband-REQNI00O000.html");
        authPage.acceptCookie();
        pdPage.addProductToBasket()
                .getBasketCount().shouldHave(Condition.text("1"));
        open(ConfigReader.getCheckoutUrl());
        checkoutPage.getAddedProduct()
                .goToCheckout()
                .checkoutLogin(ConfigReader.getUsername(), ConfigReader.getPassword())
                .getAddedProduct()
                .goToCheckout()
                .goToPayment()
                .setPaymentTypeToPayone()
                .setPaymentData()
                .pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }
}