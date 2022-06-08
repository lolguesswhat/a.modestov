package tests;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.Test;

public class NextcloudTask extends BaseTest{
    @Test
    public void NextcloudTest () {
        AqualityServices.getApplication();
    }
}
