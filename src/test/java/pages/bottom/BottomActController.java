package pages.bottom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class BottomActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public BottomActController enterSubscribeEmail(String email) {
        driver.findElement(By.xpath("//input[@placeholder='Your email address']"))
                .sendKeys(email + Keys.ENTER);
        return this;
    }

    public void selectNewProductsLink() {
        driver.findElement(By.partialLinkText("New produc"))
                .click();
    }

    public void selectOrders() {
        driver.findElement(By.cssSelector("#footer_account_list > li:nth-child(2) > a"))
                .click();
    }
}
