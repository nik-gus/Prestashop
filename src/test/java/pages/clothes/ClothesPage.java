package pages.clothes;

import org.openqa.selenium.By;

public class ClothesPage {

    private ClothesActController act;
    private ClothesVerifyController verify;

    private ClothesPage() {
        //hidden
    }

    private ClothesPage(ClothesActController act, ClothesVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    //static factory method
    public static ClothesPage getClothesPage() {
        return new ClothesPage(new ClothesActController(), new ClothesVerifyController());
    }

    public ClothesActController act() {
        return act;
    }

    public ClothesVerifyController verify() {
        return verify;
    }

    public static By clothesHeader() {
        return By.id("js-product-list-header");
    }

    public static By clothesBreadcrumb() {
        return By.xpath("//span[contains(text(),'Clothes')]");
    }

    public static By menBreadcrumb() {
        return By.xpath("//span[contains(text(),'Men')]");
    }

    public static By sizeMFilter() {
        return By.cssSelector("#js-active-search-filters > ul > li");
    }

    public static By firstArticle() {
        return By.tagName("article");
    }

    public static By productIsAddedMessage() {
        return By.xpath("//h4[@id='myModalLabel']");
    }

}
