package screens.MainScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidMainScreen extends MainScreen{
    protected AndroidMainScreen() {
        super(By.id(""));
    }
}
