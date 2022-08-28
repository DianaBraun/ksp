package ShopPages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage extends BasePage {
    private final SelenideElement loginCheckout = $(".test-login-email");
    private final SelenideElement passCheckout = $(".test-login-password");
    private final SelenideElement signUpCheckout = $(".test-login-button");
    private final SelenideElement goToCheckoutButton = $(".test-goto-shipping-button");
    private final SelenideElement continueToPayment = $(".test-shipping-submit-button");
    private final SelenideElement iframeForCardNumber = $x("(//iframe[@frameborder=\"0\"])[1]");
    private final SelenideElement iframeForValidUntilMonth = $x("(//iframe[@frameborder=\"0\"])[2]");
    private final SelenideElement iframeForValidUntilYear = $x("(//iframe[@frameborder=\"0\"])[3]");
    private final SelenideElement iframeForCvv = $x("(//iframe[@frameborder=\"0\"])[4]");
    private final SelenideElement cardNumber = $("#cardpan");
    private final SelenideElement cardHolder = $("input[name='payment[payone][card_holder]']");
    private final SelenideElement cardExpireMonth = $("#cardexpiremonth");
    private final SelenideElement cardExpireYear = $("#cardexpireyear");
    private final SelenideElement cardCvv = $("#cardcvc2");
    private final SelenideElement checkOrder = $(".test-payment-submit");
    private final SelenideElement pay = $(".test-pay-now-button");
    private final SelenideElement thankYou = $(".thankyou-header__title");
    private final SelenideElement genderSelect = $x("//label[@for=\"shipping-gender-female\"]");
    private final SelenideElement addressName = $x("(//input[@class=\"input-box__text-input js_text_input\"])[1]");
    private final SelenideElement firstName = $(byXpath("//input[@name=\"shipping[first_name]\"]"));
    private final SelenideElement secondName = $(byXpath("//input[@name=\"shipping[last_name]\"]"));
    private final SelenideElement street = $(byXpath("//input[@name=\"shipping[street]\"]"));
    private final SelenideElement streetNo = $(byXpath("//input[@name=\"shipping[street_no]\"]"));
    private final SelenideElement postCode = $(byXpath("//input[@name=\"shipping[postal]\"]"));
    private final SelenideElement city = $(byXpath("//input[@name=\"shipping[city]\"]"));
    private final SelenideElement addedPremium = $(byXpath("//a[@href=\"https://stage.keller-sports.com/p/keller-premium-membership-UZUKS031001.html\"]"));
    private final SelenideElement addedProduct = $(byXpath("//a[@href=\"https://stage.keller-sports.com/p/nike-fury-3.0-headband-REQNI00O000.html\"]"));
    private final SelenideElement dateOfBirthDay = $(byXpath("//select[@name=\"shipping[bday_day]\"]"));
    private final SelenideElement dateOfBirthMonth = $(byXpath("//select[@name=\"shipping[bday_month]\"]"));
    private final SelenideElement dateOfBirthYear = $(byXpath("//select[@name=\"shipping[bday_year]\"]"));
    private final SelenideElement registerCheckoutButton = $(".test-show-register");
    private final SelenideElement registerCheckoutFirstname = $(".test-register-firstname");
    private final SelenideElement registerCheckoutLastname = $(".test-register-lastname");
    private final SelenideElement registerCheckoutEmail = $(".test-register-email");
    private final SelenideElement registerCheckoutPass = $(".test-register-password");
    private final SelenideElement registerCheckoutTerms = $(".test-register-terms-label");
    private final SelenideElement registerCheckout = $(".test-register-button");

    public CheckoutPage goToCheckout() {
        goToCheckoutButton.click();
        logger.info("Go to checkout");
        return new CheckoutPage();
    }

    public CheckoutPage checkoutRegister(String firstName, String lastName, String email, String pass) {
        click(registerCheckoutButton);
        registerCheckoutFirstname.sendKeys(firstName);
        registerCheckoutLastname.sendKeys(lastName);
        registerCheckoutEmail.sendKeys(email);
        registerCheckoutPass.sendKeys(pass);
        registerCheckoutTerms.scrollIntoView(true);
        registerCheckoutTerms.click(ClickOptions.usingDefaultMethod().offset(-0, 0));
        click(registerCheckout);
        logger.info("Registered a user on checkout");
        return new CheckoutPage();
    }

    public CheckoutPage goToPayment() {
        continueToPayment.shouldBe(Condition.visible);
        click(continueToPayment);
        return new CheckoutPage();
    }
    public CheckoutPage getAddedProduct() {
        addedProduct.should(Condition.exist);
        return new CheckoutPage();
    }

    public CheckoutPage getAddedPremium() {
        addedPremium.should(Condition.exist);
        return new CheckoutPage();
    }

    public CheckoutPage setPersonalDataForPremium() {
        addressName.sendKeys("TestAddressName");
        street.sendKeys("testStreet 1");
        postCode.sendKeys("12345");
        city.sendKeys("test");
        click(continueToPayment);
        logger.info("Set personal data for Premium membership");
        return new CheckoutPage();
    }

    public CheckoutPage setPaymentTypeToPayone() {
        click($(".test-choose-payone-label"));
        return new CheckoutPage();
    }

    public CheckoutPage setPaymentData() {
        iframeForCardNumber.should(Condition.exist);
        switchTo().frame(iframeForCardNumber);
        cardNumber.sendKeys("4000060000000006");
        switchTo().parentFrame();
        cardHolder.sendKeys("test test");
        switchTo().frame(iframeForValidUntilMonth);
        cardExpireMonth.selectOptionByValue("3");
        switchTo().parentFrame();
        switchTo().frame(iframeForValidUntilYear);
        cardExpireYear.selectOptionByValue("2030");
        switchTo().parentFrame();
        switchTo().frame(iframeForCvv);
        cardCvv.sendKeys("737");
        switchTo().parentFrame();
        click(checkOrder);
        pay.should(Condition.exist);
        logger.info("Set payment data");
        return new CheckoutPage();
    }
    public void pay() {
        pay.shouldBe(Condition.exist);
        click(pay);
        logger.info("Paid for product");
    }

    public SelenideElement getThankYouText() {
        return thankYou;
    }
    public CheckoutPage checkoutLogin(String checkoutLogin, String checkoutPass) {
        loginCheckout.sendKeys(checkoutLogin);
        passCheckout.sendKeys(checkoutPass);
        click(signUpCheckout);
        logger.info("Logged in at checkout");
        return new CheckoutPage();
    }
}