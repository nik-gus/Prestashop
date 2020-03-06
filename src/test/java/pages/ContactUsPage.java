package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrestaShopContactUs {
    static WebDriver driver;

    public static WebElement findSubjectDropDown(WebDriver driver) {
       return driver.findElement(By.name("id_contact"));
    }

    public static WebElement findMessageTextArea(WebDriver driver) {
        return driver.findElement(By.name("message"));
    }

    public static WebElement findSendButton(WebDriver driver) {
        return driver.findElement(By.name("submitMessage"));
    }

    public static WebElement findEmailField(WebDriver driver) {
        return driver.findElement(By.name("from"));
    }

    public static WebElement findMessageConfirmation(WebDriver driver) {
        return driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[2]/section[1]/section[1]/section[1]/form[1]/div[1]/ul[1]/li[1]"));
    }
}
