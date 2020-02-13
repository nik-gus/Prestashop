import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestashopTest {
    static WebDriver driver;

    @BeforeClass
    public static void startup() {
        driver = new ChromeDriver();
        driver.get("http://demo.prestashop.com");
    }

    @Test
    public static void signIn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
//
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
        System.out.println(" navigetat till rätt frame??????");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Sign in"))).click();
        System.out.println("Efter wait");
    }

    @AfterClass
    public static void cleanup() {
        driver.quit();
    }
}
//    @BeforeClass
//     public static void beforeClass() {
//        driver = new ChromeDriver();
//   }
//
//   @Before
//    public void before() {
//        driver.get("http://demo.prestashop.com");
//   }






