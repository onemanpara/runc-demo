package run.runc.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserdata.properties")
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserSize")
    @DefaultValue("1920x1980")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://runc.run/")
    String baseUrl();

    @Key("remoteAddress")
    String remoteAddress();

}
