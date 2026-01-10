package drivers;

public class DriverSelector {
    public static String getDriver() {
        String deviceHost = System.getProperty("deviceHost", "emulation");

        if ("browserstack".equals(deviceHost)) {
            return "drivers.BrowserstackDriver";
        } else {
            return "drivers.LocalDriver";
        }
    }
}