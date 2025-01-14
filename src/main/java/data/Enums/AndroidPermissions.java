package data.Enums;

public enum AndroidPermissions {
    CAMERA("android.permission.CAMERA"),
    LOCATION("android.permission.ACCESS_FINE_LOCATION"),
    STORAGE("android.permission.WRITE_EXTERNAL_STORAGE"),
    MICROPHONE("android.permission.RECORD_AUDIO"),
    BLUETOOTH_SCAN("android.permission.BLUETOOTH_SCAN"),
    BLUETOOTH_CONNECT("android.permission.BLUETOOTH_CONNECT"),
    NEARBY_WIFI_DEVICES("android.permission.NEARBY_WIFI_DEVICES"),
    POST_NOTIFICATIONS("android.permission.POST_NOTIFICATIONS"),
    ACCESS_FINE_LOCATION("android.permission.ACCESS_FINE_LOCATION"),
    ACCESS_COARSE_LOCATION("android.permission.ACCESS_COARSE_LOCATION"),
    ACCESS_BACKGROUND_LOCATION("android.permission.ACCESS_BACKGROUND_LOCATION");

    private final String value;

    AndroidPermissions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
