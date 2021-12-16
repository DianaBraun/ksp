package tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

import static common.Constants.*;


public class Test1_Auth extends BaseTest {

    @Test
    public void successfulSignInFlow() throws Exception{

        LoginPage loginSteps = new LoginPage(driver);
        loginSteps.launchBrowser();
        loginSteps.setCookiesAccept();
        loginSteps.loginClick();
        loginSteps.fillInUserDetails(loginEmail, loginPassword);
        loginSteps.signInClick();
        loginSteps.checkSignInStatus();

    }
}



