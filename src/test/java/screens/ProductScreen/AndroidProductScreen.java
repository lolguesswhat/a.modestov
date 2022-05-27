package screens.ProductScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidProductScreen extends ProductScreen {
    public AndroidProductScreen() {
        super(By.id("com.zdv.secretcloset:id/tvItemPrice"));
    }

    @Override
    protected By getOldPriceBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemOriginalPrice");
    }

    @Override
    protected By getDiscountBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemDiscount");
    }

    @Override
    protected By getPriceWithDiscountBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemPrice");
    }

    @Override
    protected By getBrandBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemBrand");
    }

    @Override
    protected By getSellerNameBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemSellerName");
    }

    @Override
    protected By getSellerCityBtn() {
        return By.id("com.zdv.secretcloset:id/tvItemSellerCity");
    }
}
