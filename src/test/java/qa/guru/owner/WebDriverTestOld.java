package qa.guru.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qa.guru.owner.config.old.WebDriverProviderOld;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("webDriverTestOld")
public class WebDriverTestOld {

    private WebDriver driver;

    //подготовка Driver
    @BeforeEach
    public void startDriver(){
        driver = new WebDriverProviderOld().get();
    }

    //тело выполнения теста
    @Test
    public void testGitHubOld(){
        String title = driver.getTitle();
        assertEquals("GitHub: Where the world builds software · GitHub",title);
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }
}
