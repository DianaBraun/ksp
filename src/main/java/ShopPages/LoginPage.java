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
    private final SelenideElement socialFbButton = $("btn btn--fb-blue");
    private final SelenideElement passwordField = $("input[name='password']");
    private final SelenideElement repeatPasswordField = $("input[name=\"password_confirmation\"]");
    private final SelenideElement termsCheckbox = $("label[for='terms-agree']");
    private final SelenideElement registerButton = $(".test-register-button");
    private final SelenideElement loginButton = $(".test-login-button");
    private final SelenideElement successRegText = $(byXpath("//h4[@class=\"layer-title\"]"));
    private final SelenideElement weakPassMessage = $(byXpath("(//*[@class = 'input-box__note input-box__note--error']) [2]"));
    private final SelenideElement wrongPassMessage = $("div> .input-box__note--error");
    private final SelenideElement loggedIn = $(byXpath("//div[@class=\"header-top-right__dropdown-hold header-top-right__dropdown-hold--user show-desktop\"]"));

    public void openLoginPage(){
        $(".test-login-link").click();
        logger.info("Opened login page");
    }
    public SelenideElement openRegPageText() {
        return successRegText;
    }
    public SelenideElement getLoggedIn(){
        return loggedIn;
    }

    public SelenideElement getWeakPassMessage() {
        return weakPassMessage;
    }

    public SelenideElement getWrongPassMessage() {
        return wrongPassMessage;
    }

    public void registerUser(String emailFieldValue, String passwordFieldValue, String repeatPasswordFieldValue) {
        LoginPage loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.openLoginPage();
        click($( ".test-register-popup-button"));
        loginPage.openRegPageText().shouldHave(Condition.exactText("CREATE CUSTOMER ACCOUNT"));
        click(emailField);
        emailField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        repeatPasswordField.sendKeys(repeatPasswordFieldValue);
        termsCheckbox.click(ClickOptions.usingDefaultMethod().offset(-150,0));
        click(registerButton);
        logger.info("User Registered");
    }
    
    public LoginPage authorizeUser(String emailFieldValue, String passwordFieldValue) {
        LoginPage loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.openLoginPage();
        click(loginField);
        loginField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        loginButton.click();
        logger.info("User Authorized");
        return new LoginPage();
    }

    public LoginPage socialGoogleLogin(String emailFieldValue, String passwordFieldValue) {
        LoginPage loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.openLoginPage();
        click(loginField);
        click(socialGoogleButton);
        //TODO: create function for social login when stage is fixed
        logger.info("User Authorized");
        return new LoginPage();
    }
}
