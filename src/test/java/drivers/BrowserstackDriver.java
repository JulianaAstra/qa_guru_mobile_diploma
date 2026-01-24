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

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

        caps.setCapability("browserstack.user", config.user());
        caps.setCapability("browserstack.key", config.key());
        caps.setCapability("app", config.app());
        caps.setCapability("device", config.device());
        caps.setCapability("os_version", config.osVersion());
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL(config.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}