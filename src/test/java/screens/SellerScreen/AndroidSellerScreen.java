package screens.SellerScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import constants.LocatorsConstants;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidSellerScreen extends SellerScreen {

    public AndroidSellerScreen() {
        super(By.id("ivSellerAvatar"));
    }

    @Override
    protected By getSellerNameLblLoc() {
        return By.xpath(String.format("//android.view.ViewGroup[@resource-id='%s/toolbar']/android.widget.TextView", LocatorsConstants.SECRET_CLOSET_ID));
    }

    @Override
    protected By getSellerCityLblLoc() {
        return By.id("tvItemSellerCity");
    }
}
