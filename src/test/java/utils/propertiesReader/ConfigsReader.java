package utils.propertiesReader;

import constants.Paths;
import org.aeonbits.owner.Config;

@Config.Sources("file:" + Paths.PATH_TO_RESOURCES + "configs.properties")
public interface ConfigsReader extends Config {
    String uri();
}
