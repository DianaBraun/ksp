import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegTest extends BaseTest {
    Faker faker = new Faker();
    LoginPage authPage = new LoginPage();
    private final String email = faker.internet().emailAddress();


    @Test(description = "Registration")
    void successRegTest() {
        open("/");
        authPage.registerUser(email, "TestPassword1!", "TestPassword1!");
        authPage.openRegPageText().shouldHave(Condition.text("REGISTRATION SUCCESSFUL"));
        Assert.assertEquals(authPage.openRegPageText().text(), "REGISTRATION SUCCESSFUL");
    }

    @Test(description = "Тест на неуспішну реєстрацію зі слабким паролем", retryAnalyzer = RetryAnalyzer.class)
    void weakPassTest() {
        open("/");
        authPage.registerUser(email, "testPass", "testPass");
        authPage.getWeakPassMessage().shouldHave(Condition.text("The password is too weak. It must contain at least 6 characters: upper and lower case letters, at least one number and at least one special character."));
        Assert.assertEquals(authPage.getWeakPassMessage().text(), "The password is too weak. It must contain at least 6 characters: upper and lower case letters, at least one number and at least one special character.");
    }
}
