package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static common.Constants.registerPassword;


public class Test2_Register extends BaseTest {

    @Test
    public void successfulSignUpFlow() throws Exception{
        WebDriver driver = new ChromeDriver();
        RegisterPage registerSteps = new RegisterPage(driver);
        Faker faker = new Faker();
        registerSteps.launchBrowser();
        registerSteps.setCookiesAccept();
        registerSteps.registerClick();
        String email = faker.internet().emailAddress();
        registerSteps.fillInUserDetails(email, registerPassword);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
