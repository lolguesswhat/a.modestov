package screens.ChooseCityScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidChooseCity extends ChooseCityScreen{
    public AndroidChooseCity() {
        super(id("com.zdv.secretcloset:id/etSearchTest"));
    }
    @Override
    protected By getDontShowAgainBtn() {
        return id("android:id/button2");
    }

    @Override
    protected By getSearchTbx() {
        return id("com.zdv.secretcloset:id/etSearchTest");
    }

    @Override
    protected By getCityToChooseBtn(String city) {
        return xpath(String.format("//android.widget.TextView[@text='%s']", city));
    }
}
