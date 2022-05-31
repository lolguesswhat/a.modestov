package screens.MainScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import constants.LocatorsConstants;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidMainScreen extends MainScreen {

    public AndroidMainScreen() {
        super(id("imageView3"));
    }

    @Override
    protected By getChooseCityBtnLoc() {
        return id("tvToolbarCity");
    }

    @Override
    protected By getBrandNameLblLoc() {
        return By.id("tvBrand");
    }

    @Override
    protected By getOriginalPriceLblLoc() {
        return By.id("tvSumm");
    }

    @Override
    protected By getDiscountLblLoc() {
        return By.xpath(String.format("//*[@resource-id='%s/tvDiscount']", LocatorsConstants.SECRET_CLOSET_ID));
    }

    @Override
    protected By getPriceWithDiscountLblLoc() {
        return By.id("tvPrice");
    }

    @Override
    protected By getProductBtnLoc() {
        return By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout");
    }
}
