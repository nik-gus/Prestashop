package pages.history;

public class HistoryPage {

    private HistoryActController act;
    private HistoryVerifyController verify;

    private HistoryPage() {
        //no access
    }

    public HistoryPage(HistoryActController act, HistoryVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static HistoryPage getHistoryPage() {
        return new HistoryPage(new HistoryActController(), new HistoryVerifyController());
    }

    public HistoryActController act() {
        return act;
    }

    public HistoryVerifyController verify() {
        return verify;
    }
}
