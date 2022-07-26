package home.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:config/${hostName}.properties"
)
public interface PracticeFormWithPageObjectConfig extends Config {

    @Key("remoteWebDriverUrl")
//    @DefaultValue("http://localhost:4444/wd/hub")
    String getRemoteUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
//    @DefaultValue("102")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1079")
    String getBrowserSize();

}
