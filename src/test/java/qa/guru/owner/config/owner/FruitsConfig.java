package qa.guru.owner.config.owner;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {

    @Key("array")
    String[] getFruitsArray();

    @Key("arrayWithDefaultValues")
    @DefaultValue("orange, apple")
    String[] getFruitsArrayWithDefaultValues();

    @Key("list")
    List<String> getFruitsList();

    @Key("listWithDefaultValues")
    @DefaultValue("orange,banana")
    List<String> getFruitsListWithDefaultValues();

    @Key("listWithDefaultValuesAndSeparator")
    @DefaultValue("orange;banana")
    @Separator(";")
    List<String> getFruitsListWithDefaultValuesAndSeparator();
}
