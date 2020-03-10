package pages.start;

public class StartPage {

    private StartActController act;
    private StartVerifyController verify;

    private StartPage() {
        //hidden
    }

    private StartPage(StartActController act, StartVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static StartPage getStartPage() {
        return new StartPage(new StartActController(), new StartVerifyController());
    }

    public StartActController act() {
        return act;
    }

    public StartVerifyController verify() {
        return verify;
    }

}
