package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("url")
    String url();

    @Key("app")
    String app();

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
