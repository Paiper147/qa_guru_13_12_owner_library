package qa.guru.owner.config.old;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProviderOld implements Supplier<WebDriver> {

    private final WebDriverConfigOld config;

    public WebDriverProviderOld() {
        this.config = new WebDriverConfigOld();
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createDriver(){
        switch (config.getBrowser()){
            case CHROME:{
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX:{
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default:{
                throw new RuntimeException("No such driver");
            }
        }
    }
}
