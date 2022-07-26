package qa.guru.owner.config.owner;

import org.aeonbits.owner.Config;
import qa.guru.owner.config.Browser;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public interface TypeConfig extends Config {

    @Key("integer")
    Integer getInteger();

    @Key("double")
    Double getDouble();

    @Key("boolean")
    Boolean getBoolean();

    @Key("enum")
    Browser getEnum();

    @Key("file")
    File getFile();

    @Key("url")
    URL getUrl();

    @Key("path")
    Path getPath();

    @Key("byteArray")
    Byte[] getByteArray();
}
