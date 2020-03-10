package pages.bottom;

public class BottomMenu {

    private BottomActController act;
    private BottomVerifyController verify;

    private BottomMenu() {
        //hidden
    }

    private BottomMenu(BottomActController act, BottomVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    //static factory method
    public static BottomMenu getBottomMenu() {
        return new BottomMenu(new BottomActController(), new BottomVerifyController());
    }

    public BottomActController act() {
        return act;
    }

    public BottomVerifyController verify() {
        return verify;
    }

}
