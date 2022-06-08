package tests;

import client.requests.JSONPlaceholder;
import client.ApiClientGenerator;

public class BaseTest {
    protected JSONPlaceholder jsonPlaceholder = ApiClientGenerator.getClient(JSONPlaceholder.class);
}
