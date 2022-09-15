package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;
abstract public class BaseTest {
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
    }
    @BeforeEach
    public void init() {
        setUp();
    }
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
    public static String getValue(int x) {
        return String.valueOf(Math.log(Math.abs(12 * Math.sin(x))));
    }
}
