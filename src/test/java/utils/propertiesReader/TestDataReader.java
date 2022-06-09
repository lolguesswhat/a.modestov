package utils.propertiesReader;

import constants.Paths;
import org.aeonbits.owner.Config;

@Config.Sources("file:" + Paths.PATH_TO_RESOURCES + "testData.properties")
public interface TestDataReader extends Config {

    int test2ExpectedUserId();

    int test2PostNumber();

    int test3PostNumber();

    String test3ExpectedBody();

    int test4UserId();

    int test5ExpectedId();

    String test5PathToUser5();
}
