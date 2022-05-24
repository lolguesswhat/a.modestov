package screens.ProductScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidProductScreen extends ProductScreen {
    public AndroidProductScreen() {
        super(By.xpath("//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvItemPrice']"));
    }

    @Override
    protected By getOldPriceBtn() {
        return //TODO;
    }

    @Override
    protected By getDiscountBtn() {
        return //TODO;
    }

    @Override
    protected By getSalePriceBtn() {
        return By.xpath("//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvItemPrice']");
    }

    @Override
    protected By getBrandBtn() {
        return By.xpath("//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvItemBrand']");
    }
}
