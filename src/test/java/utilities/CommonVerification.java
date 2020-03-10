package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static prestashop.DriverFactory.getChromeDriver;

public class CommonVerification {

    private WebDriver driver = getChromeDriver();

    private CommonVerification () {
        // hidden
    }

    public static CommonVerification getCommonVerification() {
        return new CommonVerification();
    }

    public CommonVerification verifyIsDisplayed(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
        return this;
    }

    public CommonVerification verifyPageTitle(String title) {
        Assert.assertEquals(title, driver.getTitle());
        return this;
    }

    public CommonVerification verifyHeader(By element, ProductListHeader header) {
        Assert.assertTrue(driver.findElement(element)
                .getText()
                .contains(header.toString()));
        return this;
    }

    public CommonVerification verifyText(String text, By element) {
        Assert.assertTrue(driver.findElement(element).getText().startsWith(text));
        return this;
    }
}
