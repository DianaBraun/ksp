import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

abstract public class BaseTest {


    @BeforeClass
    public void setUp() {
//        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "https://keller:sports17@stage.keller-sports.com";
        Configuration.browserSize = "1700x1000";
        Configuration.timeout = 10000;

    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}