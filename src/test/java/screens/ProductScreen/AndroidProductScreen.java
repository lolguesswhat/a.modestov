package screens.ProductScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidProductScreen extends ProductScreen {

    public AndroidProductScreen() {
        super(By.id("tvAdditionalId"));
    }

    @Override
    protected By getOriginalPriceLblLoc() {
        return By.id("tvItemOriginalPrice");
    }

    @Override
    protected By getDiscountLblLoc() {
        return By.id("tvItemDiscount");
    }

    @Override
    protected By getPriceWithDiscountLblLoc() {
        return By.id("tvItemPrice");
    }

    @Override
    protected By getBrandNameLblLoc() {
        return By.id("tvItemBrand");
    }

    @Override
    protected By getSellerNameLblLoc() {
        return By.id("tvItemSellerName");
    }

    @Override
    protected By getSellerCityLblLoc() {
        return By.id("tvItemSellerCity");
    }
}
