package tests;

import adapter.JSONPlaceholder;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected JSONPlaceholder jsonPlaceholder;

    @BeforeMethod
    public void beforeMethod() {
        jsonPlaceholder = Feign.builder().decoder(new GsonDecoder()).target(JSONPlaceholder.class,
                "https://jsonplaceholder.typicode.com/users");
    }
}
