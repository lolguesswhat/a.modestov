package utils.propertiesReader;

import org.aeonbits.owner.Config;

@Config.Sources("file:src\\test\\resources\\configs.properties")
public interface ConfigsReader extends Config {
    String uri();
}
