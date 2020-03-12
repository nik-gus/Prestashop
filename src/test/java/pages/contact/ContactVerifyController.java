package pages.contact;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class ContactVerifyController {


    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public ContactVerifyController messageConfirmation() {
        String confirmation = driver.findElement(By.cssSelector("#content > section > form > div > ul > li")).getText();
        Assert.assertEquals("Your message has been successfully sent to our team.", confirmation);
        return this;
    }

    public ContactVerifyController webmasterIsSelected() {
        String subjectValue = driver.findElement(By.xpath("//select[@name='id_contact']"))
                .getAttribute("value");
        Assert.assertEquals("1", subjectValue);
        return this;
    }

}
