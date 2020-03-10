package pages.top;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class TopVerifyController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public TopVerifyController userLoggedIn(String userName) {
        Assert.assertEquals(userName, getUserName());
        return this;
    }

    public String getUserName() {
        return driver.findElement(By.cssSelector("#_desktop_user_info > div > a.account > span")).getText();
    }

}
