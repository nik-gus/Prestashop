package pages.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class StartActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public StartActController selectArticleNo(int articleNo) {
        driver.findElement(By.xpath("//article[" +articleNo +"]"))
                .click();
        return this;
    }

}
