import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    @BeforeClass
    public void setUp() throws IOException {
//        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = ConfigReader.getUrl();
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}