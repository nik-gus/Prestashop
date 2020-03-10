package pages.top;

public class TopMenu {

    private TopActController act;
    private TopVerifyController verify;

    private TopMenu() {
        //hidden
    }

    private TopMenu(TopActController act, TopVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    //static factory method
    public static TopMenu getTopMenu() {
        return new TopMenu(new TopActController(), new TopVerifyController());
    }

    public TopActController act() {
        return act;
    }

    public TopVerifyController verify() {
        return verify;
    }







}








