package pages.newProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static prestashop.DriverFactory.getChromeDriver;
import static prestashop.DriverFactory.getWebDriverWait;

public class NewProductsVerifyController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    /* Make a list of all articles, extracts prices to a separate priceList, verifys the sort order is ascending*/
    public NewProductsVerifyController verifySortOrderPriceAsc() {
        List<WebElement> articles = driver.findElements(By.tagName("article"));
        List<Double> priceList = new ArrayList<>();
        articles.stream()
                .map(WebElement::getText)
                .mapToDouble(a -> Double.parseDouble(a.substring(a.indexOf('£') + 1, a.indexOf('£') +6)))
                .forEach(priceList::add);

        //Assert.assertTrue(Ordering.<Double> natural().isOrdered(priceList)); //Junit
        assertThat(priceList).isNotEmpty()                                      //AssertJ
                .isSorted();
        return this;
    }


}
