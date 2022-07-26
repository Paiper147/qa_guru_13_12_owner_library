package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.owner.FruitsConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitsTests {

    @Test
    public void testArray(){
        System.setProperty("array", "banana,apple");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsArray()).containsExactly("banana","apple");
    }

    @Test
    public void testArrayWithDefaultValues(){
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsArrayWithDefaultValues()).containsExactly("orange","apple");
    }

    @Test
    public void testList(){
        System.setProperty("list", "apple,orange");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsList()).containsExactly("apple","orange");
    }

    @Test
    public void testListWithDefaultValues(){
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsListWithDefaultValues()).containsExactly("orange","banana");
    }

    @Test
    public void testListWithDefaultValuesAndSeparator(){
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsListWithDefaultValuesAndSeparator()).containsExactly("orange","banana");
    }
}
