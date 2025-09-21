import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public abstract class BaseTest {
    public void setup(){
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "128.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});
        Configuration.browserCapabilities = options;
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
