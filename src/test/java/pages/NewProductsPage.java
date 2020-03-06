package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PrestaShopNewProducts {

    public static List<WebElement> findArticlesSortedByPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
         wait.until(ExpectedConditions.urlContains("product.price.asc"));
        return driver.findElements(By.tagName("article"));
    }

    public static WebElement findSortByDropDown(WebDriver driver) {
        //return driver.findElement(By.cssSelector("#js-product-list-top > div:nth-child(2) > div > div > button"));
       return driver.findElement(By.cssSelector(".select-title"));
    }

    public static WebElement findSortByPriceAscLink(WebDriver driver) {
        return driver.findElement(By.linkText("Price, low to high"));
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Price, low to high")));
    }



}
