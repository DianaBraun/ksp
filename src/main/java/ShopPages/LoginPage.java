package ShopPages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final SelenideElement emailField = $("input[type='email']");
    private final SelenideElement loginField = $("#js_login_email");
    private final SelenideElement socialGoogleButton = $(".test-login-google-button");
    private final SelenideElement passwordField = $("input[name='password']");
    private final SelenideElement repeatPasswordField = $("input[name=\"password_confirmation\"]");
    private final SelenideElement termsCheckbox = $("label[for='terms-agree']");
    private final SelenideElement registerButton = $(".test-register-button");
    private final SelenideElement loginButton = $(".test-login-button");
    private final SelenideElement loginLink = $(".test-login-link");
    private final SelenideElement successRegText = $(byXpath("//h4[@class=\"layer-title\"]"));
    private final SelenideElement weakPassMessage = $(byXpath("(//*[@class = 'input-box__note input-box__note--error']) [2]"));
    private final SelenideElement wrongPassMessage = $("div> .input-box__note--error");
    private final SelenideElement loggedInIcon = $(byXpath("//div[@class=\"header-top-right__dropdown-hold header-top-right__dropdown-hold--user show-desktop\"]"));
    LoginPage loginPage = new LoginPage();

    public void openLoginPage() {
        loginLink.click();
        loginPage.acceptCookie();
    }

    public SelenideElement openRegPageText() {
        return successRegText;
    }

    public SelenideElement getLoggedInIcon() {
        return loggedInIcon;
    }

    public SelenideElement getWeakPassMessage() {
        return weakPassMessage;
    }

    public SelenideElement getWrongPassMessage() {
        return wrongPassMessage;
    }

    public void registerUser(String emailFieldValue, String passwordFieldValue, String repeatPasswordFieldValue) {
        loginPage.openLoginPage();
        registerButton.click();
        loginPage.openRegPageText().shouldHave(Condition.exactText("CREATE CUSTOMER ACCOUNT"));
        emailField.click();
        emailField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        repeatPasswordField.sendKeys(repeatPasswordFieldValue);
        termsCheckbox.click(ClickOptions.usingDefaultMethod().offset(-150, 0));
        registerButton.click();
    }

    public LoginPage authorizeUser(String emailFieldValue, String passwordFieldValue) {
        loginPage.openLoginPage();
        loginField.click();
        loginField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        loginButton.click();
        return this;
    }

    public LoginPage socialGoogleLogin(String emailFieldValue, String passwordFieldValue) {
        loginPage.openLoginPage();
        loginField.click();
        socialGoogleButton.click();
        return this;
    }
}