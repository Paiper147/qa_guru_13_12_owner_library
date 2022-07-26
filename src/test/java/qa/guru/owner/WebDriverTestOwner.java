package qa.guru.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qa.guru.owner.config.owner.WebDriverProviderOwner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("webDriverTestOwner")
public class WebDriverTestOwner {

    private WebDriver driver;

    //подготовка Driver
    @BeforeEach
    public void startDriver(){
        driver = new WebDriverProviderOwner().get();
    }

    //тело выполнения теста
    @Test
    public void testGitHubOwner(){
        String title = driver.getTitle();
        assertEquals("GitHub: Where the world builds software · GitHub",title);
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }
}
