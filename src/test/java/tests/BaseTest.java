package tests;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        AqualityServices.getApplication();
    }

    @AfterMethod
    public void afterMethod() {
        AqualityServices.getApplication().quit();
    }
}
