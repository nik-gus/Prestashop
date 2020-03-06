import com.google.common.collect.Ordering;
import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class PrestaShopE2ETests {

    static WebDriver driver =  new ChromeDriver();
    //static String firstName, lastName, password;
    static String testEmail;


    @BeforeClass
    public static void setup() {
        driver.get("http://localhost:8001");
        loadTestData();
    }

    private static void loadTestData() {
        testEmail = "mail@mailinator.com";
    }

    @Before
    public void goHome() {
        PrestaShopTopMenu.findHomeButton(driver).click();
    }

    /* User Story 1: som en användare vill jag skapa ett konto så att jag kan handla snabbare */
    @Test
    public void createAccount() {
        PrestaShopTopMenu.findSignInButton(driver).click();
        PrestaShopLogIn.findCreateAccountButton(driver).click();
        PrestaShopCreateAccount.findRadioButtonMr(driver).click();
        PrestaShopCreateAccount.findFirstName(driver).sendKeys("Tolvan" + Keys.ENTER);
        PrestaShopCreateAccount.findLastName(driver).sendKeys("Tolvansson" + Keys.ENTER);
        PrestaShopCreateAccount.findEmail(driver).sendKeys(testEmail +Keys.ENTER);
        PrestaShopCreateAccount.findPassword(driver).sendKeys("Tolvan12" +Keys.ENTER);
        PrestaShopCreateAccount.findAgreeToTerms(driver). click();
        PrestaShopCreateAccount.findSaveButton(driver).click();
        Assert.assertEquals("Tolvan Tolvansson", PrestaShopTopMenu.findUserName(driver).getText());
    }

    /* User story 2: som en användare vill jag signa up på nyhetsbrevet så att jag kan ta del av nyheter */
    @Test
    public void subscribeNewsletter() {
        PrestaShopStart.findSubscribeField(driver).sendKeys(testEmail +Keys.ENTER);
        Assert.assertTrue(PrestaShopStart.findSubscribeMessage(driver).contains("successfully subscribed"));
    }

    /* User story 3: Som en epileptiker  vill jag kontakta Webmaster och klaga på färgvalen på my store-länken */
    @Test
    public void messageWebmaster() {
        PrestaShopTopMenu.findContactButton(driver).click();
        Assert.assertEquals("Contact us", driver.getTitle());
        WebElement dropDown = PrestaShopContactUs.findSubjectDropDown(driver);
        Select select = new Select(dropDown);
        select.selectByVisibleText("Webmaster");
        Assert.assertEquals("1", dropDown.getAttribute("value"));

        WebElement emailField = PrestaShopContactUs.findEmailField(driver);
        /* utan clear() nedan läggs emailadressen in dubbelt.  */
        emailField.clear();
        emailField.sendKeys(testEmail);
        emailField.submit();
        PrestaShopContactUs.findMessageTextArea(driver).sendKeys("I'm getting dizzy!");
        PrestaShopContactUs.findSendButton(driver).click();
        Assert.assertEquals("Your message has been successfully sent to our team.", PrestaShopContactUs.findMessageConfirmation(driver).getText());
    }

    /* User story: Som en återkommande kund vill jag se nyainkomna varor, sorterade efter lågt pris
     * för att hålla mig uppdaterad om sortimentet */
    @Test
    public void browseNewProductsSortedByPriceAsc() throws InterruptedException {
        PrestaShopStart.findNewProductLink(driver).click();
        PrestaShopNewProducts.findSortByDropDown(driver).click();
        PrestaShopNewProducts.findSortByPriceAscLink(driver).click();
        /*
        Fulhack för att kolla att produkterna har sorterats i pris-ordning.
        Plockar ut priset från varje artikel in i en separat lista (priceList)
        och kollar att den listan är i korrekt ordning.
         */
        List<WebElement> articles = PrestaShopNewProducts.findArticlesSortedByPrice(driver);
        List<Double> priceList = new ArrayList<>();
        articles.stream()
                .map(a -> a.getText())
                .mapToDouble(a -> Double.parseDouble(a.substring(a.indexOf('£') + 1, a.indexOf('£') +6)))
                .forEach(priceList::add);
        Assert.assertTrue(Ordering.<Double> natural().isOrdered(priceList));
    }


    /* User story 4: Som en shop-a-holic vill jag kunna köpa en onödig vara för att tillfredställa mitt beroende */


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
