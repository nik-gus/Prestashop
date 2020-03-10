package pages.clothes;

public enum Size {

    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String value;

    Size(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
