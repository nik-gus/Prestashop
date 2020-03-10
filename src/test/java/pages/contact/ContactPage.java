package pages.contact;

public class ContactPage {

    private ContactActController act;
    private ContactVerifyController verify;

    private ContactPage() {
        //hidden
    }

    private ContactPage(ContactActController act, ContactVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static ContactPage getContactUsPage() {
        return new ContactPage(new ContactActController(), new ContactVerifyController());
    }

    public ContactActController act() {
        return act;
    }

    public ContactVerifyController verify() {
        return verify;
    }

}

