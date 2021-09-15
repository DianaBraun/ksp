package pages;

import common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends AbstractPage {

    @FindBy(css = ".js_overlays-wrap .test-login-link")
    private WebElement loginButton;


    @FindBy(css = ".test-register-popup-button")
    private WebElement registerButton;

    @FindBy(xpath = "//button[@id='uc-btn-accept-banner']")
    private WebElement cookiesAccept;

    @FindBy(css = ".test-country-layer__close")
    private WebElement closeCountryLayer;

    @FindBy(css = "#email-create")
    private WebElement registerEmailField;

    @FindBy(css = "#password-create1")
    private WebElement registerPassField;

    @FindBy(css = "#password-create2")
    private WebElement repeatPassField;

    @FindBy(css = ".test-register-terms")
    private WebElement acceptTermsCheckbox;

    @FindBy(css = ".test-register-button")
    private WebElement registerAccountButton;


    public RegisterPage(WebDriver driver) {
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

    public void registerClick() {
        loginButton.click();
        waitForElementToAppear(registerButton);
        registerButton.click();
    }

    public void fillInUserDetails(String email, String registerPassword) {
        registerEmailField.clear();
        registerEmailField.sendKeys(email);
        registerPassField.clear();
        registerPassField.sendKeys(registerPassword);
        repeatPassField.sendKeys(registerPassword);
        acceptTermsCheckbox.click();
        registerAccountButton.click();
    }
}
