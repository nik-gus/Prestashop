package pages.newProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class NewProductsActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public NewProductsActController selectSortBy() {
        driver.findElement(By.className("select-title"))
                .click();
        return this;
    }

    public NewProductsActController selectSortByPriceAsc() {
        driver.findElement(By.linkText("Price, low to high"))
                .click();
        wait.until(ExpectedConditions.urlContains("product.price.asc"));
        return this;
    }

}
