package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrestaShopCreateAccount {
    static WebDriver driver;

    public static WebElement findRadioButtonMr(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='col-md-6 form-control-valign']//label[1]"));
    }

    public static WebElement findFirstName(WebDriver driver) {
        return driver.findElement(By.name("firstname"));
    }

    public static WebElement findLastName(WebDriver driver) {
        return driver.findElement(By.name("lastname"));
    }

    public static WebElement findEmail(WebDriver driver) {
        return driver.findElement(By.name("email"));
    }

    public static WebElement findPassword(WebDriver driver) {
        return driver.findElement(By.name("password"));
    }

    public static WebElement findAgreeToTerms(WebDriver driver) {
        return driver.findElement(By.name("psgdpr"));
    }

    public static WebElement findSaveButton(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer-form > footer > button"));
    }
}
