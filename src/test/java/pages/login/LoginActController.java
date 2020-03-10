package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class LoginActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public LoginActController selectCreateAccountLink() {
        driver.findElement(By.partialLinkText("No account? Create"))
                .click();
        return this;
    }

    public LoginActController enterSignInEmail(String email) {
        driver.findElement(By.name("email"))
                .sendKeys(email);
        return this;
    }

    public void enterSignInPassword(String password) {
        driver.findElement(By.name("password"))
                .sendKeys(password + Keys.ENTER);
    }

}
