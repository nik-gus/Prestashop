package pages.newProducts;

import org.openqa.selenium.By;

public class NewProductsPage {

    private NewProductsActController act;
    private NewProductsVerifyController verify;

    private NewProductsPage() {
        //hidden
    }

    private NewProductsPage(NewProductsActController act, NewProductsVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static NewProductsPage getNewProductsPage() {
        return new NewProductsPage(new NewProductsActController(), new NewProductsVerifyController());
    }

    public NewProductsActController act() {
        return act;
    }

    public NewProductsVerifyController verify() {
        return verify;
    }

    public static By newProductsHeader() {
        return By.id("js-product-list-header");
    }

}
