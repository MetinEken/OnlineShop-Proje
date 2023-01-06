package OnlineShoping.category;

public enum CategoryType {

    PHONE("SMART_PHONE"),
    COMPUTER("DESKTOP / LABTOP"),
    KEYBOARD( "KEYBOARD / MOUSE"),
    OTHER("OTHER"),
    CABLE("HDMI / VGA / ADAPTOR");

private final String value;
    CategoryType(String value) {
        this.value = value;
    }
}
