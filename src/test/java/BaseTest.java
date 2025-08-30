import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public abstract class BaseTest {
    public void setup(){
        WebDriverManager.chromedriver().browserInDocker().dockerNetworkHost();
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 8000;
        try {
            String userDataDir = createTempChromeDir();
            WebDriverManager.chromedriver().properties("--user-data-dir=" + userDataDir);
        } catch (Exception e) {
            throw new RuntimeException("Chrome props", e);
        }
    }

    @BeforeClass
    public void init(){
        setup();
    }

    @AfterClass
    public void test() {
        Selenide.closeWebDriver();
    }

    public static String createTempChromeDir() throws Exception {
        String baseDir = "/tmp/chrome-tmp/";
        String dirName = "chrome-tmp-" + UUID.randomUUID();
        String fullPath = baseDir + dirName;
        File base = new File(baseDir);
        for (File file : Objects.requireNonNull(base.listFiles())) {
            if (file.isDirectory() && file.getName().startsWith("chrome-tmp-")) {
                deleteDirectory(file); // recursive silme
            }
        }

        File dir = new File(fullPath);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (!created) {
                throw new RuntimeException("Dizin oluşturulamadı: " + fullPath);
            }
        }

        return fullPath;
    }

}
