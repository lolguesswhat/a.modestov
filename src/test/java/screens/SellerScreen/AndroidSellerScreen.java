package screens.SellerScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidSellerScreen extends SellerScreen{
    public AndroidSellerScreen() {
        super(By.xpath("//*[@resource-id='com.zdv.secretcloset:id/toolbar']/android.widget.TextView"));
    }

    @Override
    protected By getSellerNameBtn() {
        return By.xpath("//*[@resource-id='com.zdv.secretcloset:id/toolbar']/android.widget.TextView");
    }

    @Override
    protected By getSellerCityBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemSellerCity");
    }
}
