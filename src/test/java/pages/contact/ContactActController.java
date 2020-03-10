package pages.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class ContactActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public ContactActController selectSubjectWebmaster() {
        WebElement subject = driver.findElement(By.xpath("//select[@name='id_contact']"));
        Select select = new Select(subject);
        select.selectByVisibleText("Webmaster");
        return this;
    }

    public ContactActController enterEmail(String email) {
        WebElement emailField = driver.findElement(By.name("from"));
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public ContactActController enterMessage(String message) {
        driver.findElement(By.name("message"))
                .sendKeys(message);
        return this;
    }

    public ContactActController selectSendButton() {
        driver.findElement(By.name("submitMessage"))
                .click();
        return this;
    }

}
