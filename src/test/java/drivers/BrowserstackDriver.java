package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserstackDriver implements WebDriverProvider {
    private final BrowserstackConfig config = ConfigFactory.create(
            BrowserstackConfig.class,
            System.getProperties()
    );

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        Map<String, Object> bstackOptions = new HashMap<>();

        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:autoAcceptAlerts", true);
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);

        caps.setCapability("platformName", config.platformName());
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:app", config.app());

        bstackOptions.put("userName", config.user());
        bstackOptions.put("accessKey", config.key());
        bstackOptions.put("deviceName", config.device());
        bstackOptions.put("platformVersion", config.osVersion());
        bstackOptions.put("projectName", config.project());
        bstackOptions.put("buildName", config.build());
        bstackOptions.put("sessionName", config.name());

        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new RemoteWebDriver(
                    new URL(config.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}