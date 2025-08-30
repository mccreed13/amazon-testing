import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    public void setup(){
        WebDriverManager.chromedriver().browserInDocker().dockerNetworkHost();
        WebDriverManager.chromedriver().setup();
        WebDriverManager wdm = WebDriverManager.chromedriver();
        System.out.println(wdm.getBrowserPath().get());
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 8000;
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
