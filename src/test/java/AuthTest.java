import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import helpers.ConfigReader;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest extends BaseTest {
    LoginPage authPage = new LoginPage();

    @Test(description = "Successful authorization")
    public void successAuthTest() throws IOException {
        open("/");
        authPage.authorizeUser(ConfigReader.getUsername(), ConfigReader.getPassword());
        Assert.assertTrue(authPage.getLoggedInIcon().isDisplayed());
    }


    @Test(description = "Wrong password test", retryAnalyzer = RetryAnalyzer.class)
    void wrongPassAuthTest() throws IOException {
        open("/");
        authPage.authorizeUser(ConfigReader.getUsername(), "19111993test")
                .getWrongPassMessage().shouldHave(Condition.text("Please check your e-mail address and password."));
        Assert.assertEquals(authPage.getWrongPassMessage().text(), "Please check your e-mail address and password.");
    }
}