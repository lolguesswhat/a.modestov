package utils.propertiesReader;

import org.aeonbits.owner.ConfigFactory;

public class ReaderGetter {
    public static TestDataReader getTestDataReader() {
        return ConfigFactory.create(TestDataReader.class);
    }
    public static ConfigsReader getConfigsReader() {
        return ConfigFactory.create(ConfigsReader.class);
    }
}
