package home.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import home.owner.config.CredentialConfigForPracticeFormWithPageObject;
import home.helpers.Attach;
import home.owner.config.PracticeFormWithPageObjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBaseWithSuccessAndFailedPageObject {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

//        CredentialConfigForPracticeFormWithPageObject credentialConfigForPracticeFormWithPageObject =
//                ConfigFactory.create(CredentialConfigForPracticeFormWithPageObject.class);
        PracticeFormWithPageObjectConfig webDriverConfig = ConfigFactory.create(PracticeFormWithPageObjectConfig.class, System.getProperties());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
        Configuration.remote = webDriverConfig.getRemoteUrl();

//        gradle clean practiceFormWithPageObjectTests_test -Dbrowser=opera
//        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
//        Configuration.browserVersion = System.getProperty("browserVersion", "100");
//
//        String login = credentialConfigForPracticeFormWithPageObject.login();
//        String password = credentialConfigForPracticeFormWithPageObject.password();
//        String remoteWebDriverHttpOrHttps = System.getProperty("remoteWebDriverHttpOrHttps","https://");
//        String remoteWebDriverURL = System.getProperty("remoteWebDriverURL","selenoid.autotests.cloud/wd/hub");
//        Configuration.remote = remoteWebDriverHttpOrHttps + format("%s" + ":" + "%s" + "@" + "%s",
//                login,
//                password,
//                remoteWebDriverURL
//        );
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
