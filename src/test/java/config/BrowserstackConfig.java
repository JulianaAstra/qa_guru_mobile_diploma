package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.url")
    String url();

    @Key("app")
    String app();

    @Key("platformName")
    String platformName();

    @Key("os_version")
    String osVersion();

    @Key("device")
    String device();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
}
