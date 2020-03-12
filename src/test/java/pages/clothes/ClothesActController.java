package pages.clothes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class ClothesActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public ClothesActController selectMen() {
        driver.findElement(By.partialLinkText("Men"))
                .click();
        return this;
    }

    public ClothesActController filterSize(Size size) {
        driver.findElement(By.xpath("//a[@class='_gray-darker search-link js-search-link'][contains(text(),'" +size +"')]"))
                .click();
        return this;
    }

    public ClothesActController selectArticleOfClothingByName(String name) {
        driver.findElement(By.partialLinkText(name))
                .click();
        return this;
    }

    public ClothesActController sizeM() {
        driver.findElement(By.cssSelector("#group_1 > option:nth-child(2)"))
                .click();
        return this;
    }

    public ClothesActController colorBlack() {
        driver.findElement(By.xpath("//li[2]//label[1]//input[1]"))
                .click();
        return this;
    }

    public ClothesActController addToBasket() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']"))
                .click();
        return this;
    }

    public void proceedToCart() {
        driver.findElement(By.xpath("//a[@class='btn btn-primary']"))
                .click();
    }

}
