package utils.propertiesReader;

import org.aeonbits.owner.Config;

@Config.Sources("file:src\\test\\resources\\testData.properties")
public interface TestDataReader extends Config {

    int test2ExpectedUserId();

    int test2ExpectedId();

    int test2PostNumber();

    int test3PostNumber();

    String test3ExpectedBody();

    int test4UserId();

    int test5ExpectedId();

    String test5PathToUser5();
}
