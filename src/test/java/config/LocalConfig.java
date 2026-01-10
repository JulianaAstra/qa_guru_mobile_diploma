package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface LocalConfig extends Config {
    @Key("os_version")
    String osVersion();

    @Key("device")
    String device();
}