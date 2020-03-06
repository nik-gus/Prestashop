package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrestaShopStart {

    static WebDriver driver;

    public static WebElement findSubscribeField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@placeholder='Your email address']"));
    }

    public static String findSubscribeMessage(WebDriver driver) {
        return driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
    }

    public static WebElement findNewProductLink(WebDriver driver) {
        return driver.findElement(By.id("link-product-page-new-products-1"));
    }
}
