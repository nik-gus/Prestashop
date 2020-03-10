package pages.createAccount;

public class CreateAccountPage {

    private CreateAccountActController act;
    private CreateAccountVerifyController verify;

    private CreateAccountPage() {
        //hidden
    }

    private CreateAccountPage(CreateAccountActController act, CreateAccountVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static CreateAccountPage getCreateAccountPage() {
        return new CreateAccountPage(new CreateAccountActController(), new CreateAccountVerifyController());
    }

    public CreateAccountActController act() {
        return act;
    }

    public CreateAccountVerifyController verify() {
        return verify;
    }


}
