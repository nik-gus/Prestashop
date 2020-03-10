package pages.createAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class CreateAccountActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public CreateAccountActController selectGenderMr() {
        driver.findElement(By.xpath("//div[@class='col-md-6 form-control-valign']//label[1]"))
                .click();
        return this;
    }

    public CreateAccountActController enterFirstName(String firstName) {
        driver.findElement(By.name("firstname"))
                .sendKeys(firstName + Keys.ENTER);
        return this;
    }

    public CreateAccountActController enterLastName(String lastName) {
        driver.findElement(By.name("lastname"))
                .sendKeys(lastName +Keys.ENTER);
        return this;
    }

    public CreateAccountActController enterEmail(String email) {
        driver.findElement(By.name("email"))
                .sendKeys(email + Keys.ENTER);
        return this;
    }

    public CreateAccountActController enterPassword(String password) {
        driver.findElement(By.name("password"))
                .sendKeys(password + Keys.ENTER);
        return this;
    }

    public CreateAccountActController selectAgreeToTerms() {
        driver.findElement(By.name("psgdpr"))
                .click();
        return this;
    }

    public void selectSaveButton() {
        driver.findElement(By.cssSelector("#customer-form > footer > button"))
                .click();
    }

}
