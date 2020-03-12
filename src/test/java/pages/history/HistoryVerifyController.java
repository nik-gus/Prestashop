package pages.history;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class HistoryVerifyController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public HistoryVerifyController messageIsSent(){
        String message = driver.findElement(By.cssSelector("#notifications > div > article > ul > li")).getText().trim();
        Assert.assertEquals("Message successfully sent", message);
        return this;
    }
}
