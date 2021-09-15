package pages;

import common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends AbstractPage {

    @FindBy(css = ".js_overlays-wrap .test-login-link")
    private WebElement loginButton;

    @FindBy(css = "#js_login_email")
    private WebElement loginInput;

    @FindBy(css = "#js_login_password")
    private WebElement passwordInput;

    @FindBy(css = ".test-login-button")
    private WebElement signInButton;

    @FindBy(xpath = "//button[@id='uc-btn-accept-banner']")
    private WebElement cookiesAccept;

    @FindBy(css = ".test-country-layer__close")
    private WebElement closeCountryLayer;

    @FindBy(css = ".header-top-right--logged")
    private WebElement loggedIcon;

    @FindBy(xpath = "//h1[contains(text(),'Konto')]")
    private WebElement signInSuccess;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void launchBrowser() {
        driver.get(Constants.URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.URL, "URL Mismatch");
    }

    public void setCookiesAccept() {
        waitForElementToAppear(cookiesAccept);
        cookiesAccept.click();
        waitForElementToAppear(closeCountryLayer);
        closeCountryLayer.click();
    }

    public void loginClick() {
        waitForElementToAppear(loginButton);
        loginButton.click();
    }

    public void fillInUserDetails(String loginEmail, String loginPassword) {
        loginInput.clear();
        loginInput.sendKeys(loginEmail);
        passwordInput.clear();
        passwordInput.sendKeys(loginPassword);
    }
    public void signInClick() {

        waitForElementToAppear(signInButton);
        signInButton.click();
    }

    public void checkSignInStatus() {
        Actions action = new Actions(driver);
        action.moveToElement(loggedIcon).perform();
        waitForElementToAppear(signInSuccess);
        String actualResult = signInSuccess.getText();
        Assert.assertEquals(actualResult, "KONTO");
        }
}
