package drivers;

public class DriverSelector {
    public static String getDriver() {
        String deviceHost = System.getProperty("deviceHost", "emulation");

        switch (deviceHost) {
            case "browserstack":
                return BrowserstackDriver.class.getName();
            case "emulation":
                return EmulationDriver.class.getName();
            default:
                throw new AssertionError("Некорректный хост: " + deviceHost);
        }
    }
}