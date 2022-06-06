package tests;

import adapter.JSONPlaceholder;
import client.Client;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected JSONPlaceholder jsonPlaceholder;

    @BeforeMethod
    public void beforeMethod() {
        jsonPlaceholder = Client.runFeign();
    }
}
