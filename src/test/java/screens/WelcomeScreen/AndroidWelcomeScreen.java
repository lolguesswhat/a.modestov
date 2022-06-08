package screens.WelcomeScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidWelcomeScreen extends WelcomeScreen{
    /**
     * Constructor with parameters
     *
     * @param locator
     * @param name
     */
    protected AndroidWelcomeScreen() {
        super(By.id(""));
    }
}
