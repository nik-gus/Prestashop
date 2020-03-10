package pages.clothes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class ClothesVerifyController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public ClothesVerifyController productIsAddedToBasket() {
        WebElement element = driver.findElement(By.xpath("//*[@id='myModalLabel']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().contains("Product successfully added to your shopping cart"));
        return this;
    }

}
