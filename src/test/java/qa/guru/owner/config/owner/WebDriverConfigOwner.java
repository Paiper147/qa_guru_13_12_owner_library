package qa.guru.owner.config.owner;

import org.aeonbits.owner.Config;
import qa.guru.owner.config.Browser;

import java.net.URL;

public interface WebDriverConfigOwner extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteUrl")
    @DefaultValue("http://localhost:4444")
    URL getRemoteUrl();
}
