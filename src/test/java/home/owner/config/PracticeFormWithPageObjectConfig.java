package home.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:config/${env}.properties"
)
public interface PracticeFormWithPageObjectConfig extends Config {

    @Key("remoteWebDriverUrl")
    String getRemoteUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1079")
    String getBrowserSize();

    @Key("videoUrlPath")
    String getVideoUrlPath();

}
