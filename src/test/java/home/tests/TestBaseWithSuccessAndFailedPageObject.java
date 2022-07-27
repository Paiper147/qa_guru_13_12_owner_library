package home.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import home.helpers.Attach;
import home.owner.config.PracticeFormWithPageObjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.apache.commons.lang3.BooleanUtils.or;

public class TestBaseWithSuccessAndFailedPageObject {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
//        System.setProperty("env", "localSelenoid");

        PracticeFormWithPageObjectConfig webDriverConfig = ConfigFactory.create(PracticeFormWithPageObjectConfig.class, System.getProperties());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();

        String remoteUrl = System.getProperty("env");
        if (remoteUrl != null){
            if (remoteUrl.equals("localSelenoid") || remoteUrl.equals("remoteSelenoid")){
                Configuration.remote = webDriverConfig.getRemoteUrl();
            }
        }
    }

    @AfterEach
    void afterEach() {
        PracticeFormWithPageObjectConfig webDriverConfig = ConfigFactory.create(PracticeFormWithPageObjectConfig.class, System.getProperties());


        String videoUrlPath = webDriverConfig.getVideoUrlPath();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo(videoUrlPath);
    }

}
