package tests;


import org.testng.annotations.Test;
import pages.LoginPage;

import static common.Constants.loginEmail;
import static common.Constants.loginPassword;


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



