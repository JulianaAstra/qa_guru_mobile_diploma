package drivers;

public class DriverSelector {
    public static String getDriver() {
        String deviceHost = System.getProperty("deviceHost", "emulation");
        System.out.println("deviceHost: " + deviceHost);

        if ("browserstack".equals(deviceHost)) {
            return "drivers.BrowserstackDriver";
        } else if ("emulation".equals(deviceHost)) {
            return "drivers.LocalDriver";
        } else {
            throw new AssertionError("Некорректный хост: " + deviceHost);
        }
    }
}