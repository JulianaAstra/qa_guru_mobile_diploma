package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("browserstack.url")
    String browserstackUrl();

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
