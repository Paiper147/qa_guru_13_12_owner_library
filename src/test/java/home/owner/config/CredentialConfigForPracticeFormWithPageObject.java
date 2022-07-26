package home.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentialForPracticeFormWithPageObject.properties")
public interface CredentialConfigForPracticeFormWithPageObject extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();
}
