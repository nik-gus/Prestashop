package utilities;

public enum ProductListHeader {

    CLOTHES("CLOTHES"), NEW_PRODUCTS("NEW PRODUCTS");

    private String value;

    ProductListHeader(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
