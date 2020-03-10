package pages.bottom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;


public class BottomVerifyController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public BottomVerifyController verifySubscription() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='alert alert-success']"))
                .getText()
                .contains("successfully subscribed"));
        return this;
    }

}
