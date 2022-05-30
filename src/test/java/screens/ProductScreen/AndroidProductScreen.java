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
    protected By getOriginalPriceTextView() {
        return By.id("com.zdv.secretcloset:id/tvItemOriginalPrice");
    }

    @Override
    protected By getDiscountTextView() {
        return By.id("com.zdv.secretcloset:id/tvItemDiscount");
    }

    @Override
    protected By getPriceWithDiscountTextView() {
        return By.id("com.zdv.secretcloset:id/tvItemPrice");
    }

    @Override
    protected By getBrandTextView() {
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
