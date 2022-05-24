package screens.MainScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidMainScreen extends MainScreen {
    public AndroidMainScreen() {
        super(id("com.zdv.secretcloset:id/tvToolbarCity"));
    }

    @Override
    protected By getChooseCityBtn() {
        return id("com.zdv.secretcloset:id/tvToolbarCity");
    }

}
