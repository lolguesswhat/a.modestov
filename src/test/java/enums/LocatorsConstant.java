package enums;

public enum LocatorsConstant {
    SECRET_CLOSET_ID("com.zdv.secretcloset:id");
    LocatorsConstant(String attribute) {
        this.attribute = attribute;
    }

    private final String attribute;
    public String getValue() {
        return attribute;
    }
}
