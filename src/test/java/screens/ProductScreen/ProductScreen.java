package screens.ProductScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class ProductScreen extends Screen {
    protected final IButton oldPriceBtn;
    protected final IButton discountBtn;
    protected final IButton salePriceBtn;
    protected final IButton brandBtn;
    protected ProductScreen(By locator) {
        super(locator, "Product Screen");
        oldPriceBtn = AqualityServices.getElementFactory().getButton(getOldPriceBtn, "");
        discountBtn = AqualityServices.getElementFactory().getButton(getDiscountBtn, "");
        salePriceBtn = AqualityServices.getElementFactory().getButton(getSalePriceBtn(), "Sale Price Button");
        brandBtn = AqualityServices.getElementFactory().getButton(getBrandBtn(), "Brand Button");
    }

    protected abstract By getOldPriceBtn();
    protected abstract By getDiscountBtn();
    protected abstract By getSalePriceBtn();
    protected abstract By getBrandBtn();


    public String getSalePriceBtnText() {
        return salePriceBtn.getText();
    }
    public String getBrandBtnText() {
        return brandBtn.getText();
    }

}
