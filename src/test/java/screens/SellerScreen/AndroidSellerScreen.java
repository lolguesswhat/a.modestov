package screens.SellerScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidSellerScreen extends SellerScreen{
    protected AndroidSellerScreen() {
        super(By.xpath(""));
    }

    @Override
    protected By getSellerNameBtn() {
        return By.id("");
    }

    @Override
    protected By getSellerCityBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemSellerCity");
    }
}
