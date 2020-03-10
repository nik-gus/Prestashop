package pages.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class CartActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public CartActController proceedToCheckout() {
        driver.findElement(By.xpath("//a[@class='btn btn-primary']"))
                .click();
        return this;
    }

}
