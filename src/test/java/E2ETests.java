import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.bottom.BottomMenu;
import pages.cart.CartPage;
import pages.clothes.ClothesPage;
import pages.clothes.Size;
import pages.contact.ContactPage;
import pages.createAccount.CreateAccountPage;
import pages.history.HistoryPage;
import pages.login.LoginPage;
import pages.newProducts.NewProductsPage;
import pages.order.OrderPage;
import pages.start.StartPage;
import pages.top.TopMenu;
import utilities.CommonVerification;
import utilities.ProductListHeader;

import static pages.bottom.BottomMenu.getBottomMenu;
import static pages.cart.CartPage.getCartPage;
import static pages.clothes.ClothesPage.*;
import static pages.contact.ContactPage.getContactUsPage;
import static pages.createAccount.CreateAccountPage.getCreateAccountPage;
import static pages.history.HistoryPage.getHistoryPage;
import static pages.login.LoginPage.*;
import static pages.newProducts.NewProductsPage.getNewProductsPage;
import static pages.newProducts.NewProductsPage.newProductsHeader;
import static pages.order.OrderPage.getOrderPage;
import static pages.start.StartPage.getStartPage;
import static pages.top.TopMenu.getTopMenu;
import static utilities.CommonVerification.getCommonVerification;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class E2ETests extends BaseTestClass {
    TopMenu top = getTopMenu();
    BottomMenu bottom = getBottomMenu();
    StartPage start = getStartPage();
    CreateAccountPage createAccount = getCreateAccountPage();
    LoginPage login = getLoginPage();
    ContactPage contact = getContactUsPage();
    NewProductsPage newProducts = getNewProductsPage();
    ClothesPage clothes = getClothesPage();
    CartPage cart = getCartPage();
    OrderPage order = getOrderPage();
    HistoryPage history = getHistoryPage();
    CommonVerification common = getCommonVerification();

    static String testEmail = "tolvans_email5@mailinator.com";


    /*  User Story 1: Som en användare vill jag skapa ett konto så att jag kan handla snabbare  */
    @Test
    public void test1_createAccount() {
        top.act()
                .selectSignInButton();
        common.verifyIsDisplayed(noAccountLink());

        login.act()
                .selectCreateAccountLink();
        common.verifyIsDisplayed(customerForm());

        createAccount.act()
                .selectGenderMr()
                .enterFirstName("Tolvan")
                .enterLastName("Tolvansson")
                .enterEmail(testEmail)
                .enterPassword("Tolvan12")
                .selectAgreeToTerms()
                .selectSaveButton();

        top.verify()
                .userLoggedIn("Tolvan Tolvansson");
    }

    /* User story 2: som en användare vill jag signa up på nyhetsbrevet så att jag kan ta del av nyheter */
    @Test
    public void test2_subscribeNewsletter() {
        bottom.act()
                .enterSubscribeEmail(testEmail);
        bottom.verify()
                .subscriptionSucceeded();
    }

    /* User story 3: Som en epileptiker  vill jag kontakta Webmaster och klaga på färgvalen på my store-länken */
    @Test
    public void test3_sendMessageToWebmaster() {
        top.act()
                .selectContactButton();
        common.verifyPageTitle("Contact us");

        contact.act()
                .selectSubjectWebmaster();
        contact.verify()
                .webmasterIsSelected();

        contact.act()
                .enterEmail(testEmail)
                .enterMessage("I'm getting dizzy!")
                .selectSendButton();
        contact.verify()
                .messageConfirmation();
    }

    /*Uppdatering: nedanstående test fallerar efter en tid. Jag kör prestashop lokalt
        och märkte att typ 2 veckor efter nedladdning finns inga nya produkter kvar.
         Antar att Prestashop kollar nya produkter utifrån det datum produkterna skapades i min lokala databas..? */
    /* User story 4: Som en återkommande kund vill jag se nyainkomna varor, sorterade efter lågt pris
     * för att hålla mig uppdaterad om lågprissortimentet */
   // @Test
    public void test4_browseNewProductsSortedByPriceAsc() {
        bottom.act()
                .selectNewProductsLink();
        common.verifyHeader(newProductsHeader(), ProductListHeader.NEW_PRODUCTS)
                .verifyIsDisplayed(firstArticle()); //Verifierar att minst 1 artikel existerar, testet fallerar efter ca 2 veckor

        newProducts.act()
                .selectSortBy()
                .selectSortByPriceAsc();
        newProducts.verify()
                .verifySortOrderPriceAsc();
    }

    /* User story: As a medium sized male I want to buy a black Hummingbird t-shirt so that all chicks will dig me */
    @Test
    public void test5_purchaseClothesManMediumSizeHummingbird() {
        top.verify()
                .userLoggedIn("Tolvan Tolvansson");

        top.act()
                .selectClothes();

        common .verifyHeader(clothesHeader(), ProductListHeader.CLOTHES)
                .verifyIsDisplayed(clothesBreadcrumb());

        clothes.act()
                .selectMen()
                .filterSize(Size.MEDIUM);

        common.verifyPageTitle("Men")
                .verifyIsDisplayed(menBreadcrumb())
                .verifyText("Size: M", sizeMFilter()) //är korrekt filter aktivt?
                .verifyIsDisplayed(firstArticle()); //visas minst 1 artikel?

        clothes.act()
                .selectArticleOfClothingByName("Hummingbird")
                .sizeM()
                .colorBlack()
                .addToBasket();

        clothes.verify()
                .productIsAddedToBasket();

        clothes.act()
                .proceedToCart();

        cart.act()
                .proceedToCheckout();

        order.act()
                .enterAddress("Tolvgatan 12")
                .enterCity("Tolvstad")
                .enterPostalCode("1212")
                .selectContinue()
                .confirmShipping()
                .payByBankWire()
                .agreeToTerms()
                .placeOrder();

        order.verify()
                .orderConfirmed();

    }

    /* User story 6: Som en otålig kund vill jag skynda på leveransen av min order */
    @Test
    public void test6_addMessageToOrder() {
        top.verify()
                .userLoggedIn("Tolvan Tolvansson");

        bottom. act()
                .selectOrders();
        common.verifyPageTitle("Order history");

        history.act()
                .selectDetails()
                .selectFirstProduct()
                .enterMessage("Ship it already!")
                .send();

        history.verify()
                .messageIsSent();
    }
}
