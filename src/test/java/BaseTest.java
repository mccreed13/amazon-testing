import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    public void setup(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 8000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeClass
    public void init(){
        setup();
    }

    @AfterClass
    public void test() {
        Selenide.closeWebDriver();
    }
}
