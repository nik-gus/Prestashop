import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class BaseTestClass {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        driver = getChromeDriver();
        driver.get("http://localhost:8001");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = getWebDriverWait();
    }

    @Before
    public void goHome() {
//        top.act()
//                .selectHomeLink();
        driver.get("http://localhost:8001");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
