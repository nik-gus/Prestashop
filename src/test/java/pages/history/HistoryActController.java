package pages.history;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class HistoryActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public HistoryActController selectDetails() {
        driver.findElement(By.linkText("Details"))
                .click();
        return this;
    }

    public HistoryActController selectFirstProduct() {
        WebElement dropdown = driver.findElement(By.name("id_product"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        return this;
    }

    public HistoryActController enterMessage(String message) {
        driver.findElement(By.name("msgText"))
                .sendKeys(message);
        return this;
    }

    public void send() {
        driver.findElement(By.name("submitMessage"))
                .click();
    }
}
