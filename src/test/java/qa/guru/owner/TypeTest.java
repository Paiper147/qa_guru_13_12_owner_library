package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.Browser;
import qa.guru.owner.config.owner.TypeConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;


public class TypeTest {

    @Test
    public void testInteger(){
        System.setProperty("integer", "10");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getInteger()).isEqualTo(10);
    }

    @Test
    public void testDouble(){
        System.setProperty("double", "10.10");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getDouble()).isEqualTo(10.10);
    }

    @Test
    public void testBoolean(){
        System.setProperty("boolean", "true");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getBoolean()).isEqualTo(true);
    }

    @Test
    public void testEnum(){
        System.setProperty("enum", "CHROME");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getEnum()).isEqualTo(Browser.CHROME);
    }

    @Test
    public void testFile(){
        System.setProperty("file", "foobar.txt");
        File fileName = new File("foobar.txt");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getFile()).isEqualTo(fileName);
    }

    @Test
    public void testUrl(){
        System.setProperty("url", "http://owner.aeonbits.org");

        try {
            URL urlTest = new URL("http://owner.aeonbits.org");

            TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
            assertThat(config.getUrl()).isEqualTo(urlTest);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPath(){
//        System.setProperty("path", "foobar.txt");
//        Path filePath = new Path("foobar.txt");
//
//        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
//        assertThat(config.getFile()).isEqualTo(fileName);
    }
}
