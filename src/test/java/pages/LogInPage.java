package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrestaShopLogIn {

    static WebDriver driver;

    public static WebElement findCreateAccountButton(WebDriver driver) {
        return driver.findElement(By.partialLinkText("No account? Create"));
    }


}
