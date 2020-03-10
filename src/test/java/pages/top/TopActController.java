package pages.top;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class TopActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public TopActController selectSignInButton() {
        driver.findElement(By.partialLinkText("Sign in"))
                .click();
        return this;
    }

    public TopActController selectContactButton() {
        driver.findElement(By.id("contact-link"))
                .click();
        return this;
    }

    public TopActController selectHomeLink() {
        driver.findElement(By.cssSelector(("#_desktop_logo > h1 > a > img")))
                .click();
        return this;
    }

    public TopActController selectClothes() {
        driver.findElement(By.id("category-3"))
                .click();
        return this;
    }


}
