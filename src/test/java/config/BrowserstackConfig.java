package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

    @Key("platformName")
    String platformName();

    // Опционально, если используется в старом коде
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    @Key("url")
    String url();
}