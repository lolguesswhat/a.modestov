package screens.MainScreen;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidMainScreen extends MainScreen {
    public AndroidMainScreen() {
        super(id("com.zdv.secretcloset:id/tvToolbarCity"));
    }

    @Override
    protected By getChooseCityBtn() {
        return id("com.zdv.secretcloset:id/tvToolbarCity");
    }


    @Override
    protected By getBrandNameBtn() {
        return xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvBrand']");
    }

    @Override
    protected By getOldPriceBtn() {
        return By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvSumm']");
    }

    @Override
    protected By getDiscountBtn() {
        return By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvDiscount']");
    }

    @Override
    protected By getPriceWithDiscountBtn() {
        return By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvPrice']");
    }

    @Override
    protected By getProductBtn() {
        return By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]");
    }

}
