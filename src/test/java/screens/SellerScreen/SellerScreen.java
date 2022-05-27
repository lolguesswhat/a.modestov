package screens.SellerScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class SellerScreen extends Screen {
    protected final IButton sellerNameBtn;
    protected final IButton sellerCityBtn;
    protected SellerScreen(By locator) {
        super(locator, "Seller Screen");
        sellerNameBtn = AqualityServices.getElementFactory().getButton(getSellerNameBtn(), "Seller Name Button");
        sellerCityBtn = AqualityServices.getElementFactory().getButton(getSellerCityBtn(), "Seller City Button");
    }

    protected abstract By getSellerNameBtn();
    protected abstract By getSellerCityBtn();

    public String getSellerNameBtnText() {
        return sellerNameBtn.getText();
    }
    public String getSellerCityBtnText() {
        return sellerCityBtn.getText();
    }

}
