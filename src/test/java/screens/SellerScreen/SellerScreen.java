package screens.SellerScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class SellerScreen extends Screen {

    protected final ILabel sellerNameLbl;
    protected final ILabel sellerCityLbl;

    protected SellerScreen(By locator) {
        super(locator, "Seller Screen");
        sellerNameLbl = AqualityServices.getElementFactory().getLabel(getSellerNameLblLoc(), "Seller Name Button");
        sellerCityLbl = AqualityServices.getElementFactory().getLabel(getSellerCityLblLoc(), "Seller City Button");
    }

    protected abstract By getSellerNameLblLoc();

    protected abstract By getSellerCityLblLoc();

    public String getSellerNameBtnText() {
        return sellerNameLbl.getText();
    }

    public String getSellerCityBtnText() {
        return sellerCityLbl.getText();
    }
}
