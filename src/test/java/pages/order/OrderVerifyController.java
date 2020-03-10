package pages.order;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class OrderVerifyController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public OrderVerifyController orderConfirmed() {
        WebElement confirmation = driver.findElement(By.xpath("//h3[@class='h1 card-title']"));
        Assert.assertTrue(confirmation.getText().contains("YOUR ORDER IS CONFIRMED"));
        return this;
    }
}
