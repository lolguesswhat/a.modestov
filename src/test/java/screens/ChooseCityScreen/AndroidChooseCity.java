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
    protected By getSearchTbx() {
        return id("com.zdv.secretcloset:id/etSearchTest");
    }

    @Override
    protected By getCityToChooseBtn() {
        return xpath("//android.widget.TextView[@text='Madrid']");
    }
}
