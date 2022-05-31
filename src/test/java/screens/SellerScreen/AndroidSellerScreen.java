package screens.SellerScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import constants.Constants;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidSellerScreen extends SellerScreen {

    public AndroidSellerScreen() {
        super(By.id("ivSellerAvatar"));
    }

    @Override
    protected By getSellerNameLblLoc() {
        return By.xpath(String.format("//android.view.ViewGroup[@resource-id='com.zdv.secretcloset:id/toolbar']/%s",
                Constants.TEXT_VIEW));
    }

    @Override
    protected By getSellerCityLblLoc() {
        return By.id("tvItemSellerCity");
    }
}
