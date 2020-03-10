package pages.login;

import org.openqa.selenium.By;

public class LoginPage {

    private LoginActController act;
    private LoginVerifyController verify;

    private LoginPage() {
        //hidden
    }

    private LoginPage(LoginActController act, LoginVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    //static factory method
    public static LoginPage getLoginPage() {
        return new LoginPage(new LoginActController(), new LoginVerifyController());
    }

    public LoginActController act() {
        return act;
    }

    public LoginVerifyController verify() {
        return verify;
    }

    public static By noAccountLink() {
        return By.xpath("//div[@class='no-account']");
    }

    public static By customerForm() {
        return By.id("customer-form");
    }


}
