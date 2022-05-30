package screens.ProductScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.ProductModel;
import org.openqa.selenium.By;

public abstract class ProductScreen extends Screen {

    protected final ILabel originalPriceTextView;
    protected final ILabel discountTextView;
    protected final ILabel priceWithDiscountTextView;
    protected final ILabel brandTextView;
    protected final ILabel sellerNameBtn;
    protected final ILabel sellerCityBtn;

    protected ProductScreen(By locator) {
        super(locator, "Product Screen");
        originalPriceTextView = AqualityServices.getElementFactory().getLabel(getOriginalPriceTextView(), "Old Price Button");
        discountTextView = AqualityServices.getElementFactory().getLabel(getDiscountTextView(), "Discount Button");
        priceWithDiscountTextView = AqualityServices.getElementFactory().getLabel(getPriceWithDiscountTextView(), "Price With Discount Button");
        brandTextView = AqualityServices.getElementFactory().getLabel(getBrandTextView(), "Brand Button");
        sellerNameBtn = AqualityServices.getElementFactory().getLabel(getSellerNameBtn(), "Seller Name Button");
        sellerCityBtn = AqualityServices.getElementFactory().getLabel(getSellerCityBtn(), "Seller City Button");
    }

    protected abstract By getOriginalPriceTextView();

    protected abstract By getDiscountTextView();

    protected abstract By getPriceWithDiscountTextView();

    protected abstract By getBrandTextView();

    protected abstract By getSellerNameBtn();

    protected abstract By getSellerCityBtn();

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

    public ProductModel getProductInfo() {
        ProductModel productModel = new ProductModel();
        productModel.setBrand(brandTextView.getText());
        productModel.setOriginalPrice(originalPriceTextView.getText());
        productModel.setDiscount(discountTextView.getText());
        productModel.setPriceWithDiscount(priceWithDiscountTextView.getText());
        return productModel;
    }
}
