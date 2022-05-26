package screens.ProductScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class ProductScreen extends Screen {
    protected final IButton oldPriceBtn;
    protected final IButton discountBtn;
    protected final IButton priceWithDiscountBtn;
    protected final IButton brandBtn;
    protected final IButton sellerNameBtn;
    protected final IButton sellerCityBtn;
    protected ProductScreen(By locator) {
        super(locator, "Product Screen");
        oldPriceBtn = AqualityServices.getElementFactory().getButton(getOldPriceBtn(), "Old Price Button");
        discountBtn = AqualityServices.getElementFactory().getButton(getDiscountBtn(), "Discount Button");
        priceWithDiscountBtn = AqualityServices.getElementFactory().getButton(getPriceWithDiscountBtn(), "Price With Discount Button");
        brandBtn = AqualityServices.getElementFactory().getButton(getBrandBtn(), "Brand Button");
        sellerNameBtn = AqualityServices.getElementFactory().getButton(getSellerNameBtn(), "Seller Name Button");
        sellerCityBtn =AqualityServices.getElementFactory().getButton(getSellerCityBtn(), "Seller City Button");
    }

    protected abstract By getOldPriceBtn();
    protected abstract By getDiscountBtn();
    protected abstract By getPriceWithDiscountBtn();
    protected abstract By getBrandBtn();
    protected abstract By getSellerNameBtn();
    protected abstract By getSellerCityBtn();


    public String getOldPriceBtnText() {
        return oldPriceBtn.getText();
    }
    public String getDiscountBtnText() {
        return discountBtn.getText();
    }
    public String getPriceWithDiscountBtnText() {
        return priceWithDiscountBtn.getText();
    }
    public String getBrandBtnText() {
        return brandBtn.getText();
    }
    public String getSellerNameBtnText() {
        return sellerNameBtn.getText();
    }
    public ProductScreen tapSellerNameBtn() {
        sellerNameBtn.click();
        return this;
    }
    public String getSellerCityBtnText() {
        return sellerCityBtn.getText();
    }

}
