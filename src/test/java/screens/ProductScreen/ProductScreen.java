package screens.ProductScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.ProductModel;
import org.openqa.selenium.By;

public abstract class ProductScreen extends Screen {

    protected final ILabel originalPriceLbl;
    protected final ILabel discountLbl;
    protected final ILabel priceWithDiscountLbl;
    protected final ILabel brandNameLbl;
    protected final ILabel sellerNameLbl;
    protected final ILabel sellerCityLbl;

    protected ProductScreen(By locator) {
        super(locator, "Product Screen");
        originalPriceLbl = AqualityServices.getElementFactory().getLabel(getOriginalPriceLblLoc(), "Old Price Button");
        discountLbl = AqualityServices.getElementFactory().getLabel(getDiscountLblLoc(), "Discount Button");
        priceWithDiscountLbl = AqualityServices.getElementFactory().getLabel(getPriceWithDiscountLblLoc(),
                "Price With Discount Button");
        brandNameLbl = AqualityServices.getElementFactory().getLabel(getBrandNameLblLoc(), "Brand Button");
        sellerNameLbl = AqualityServices.getElementFactory().getLabel(getSellerNameLblLoc(), "Seller Name Button");
        sellerCityLbl = AqualityServices.getElementFactory().getLabel(getSellerCityLblLoc(), "Seller City Button");
    }

    protected abstract By getOriginalPriceLblLoc();

    protected abstract By getDiscountLblLoc();

    protected abstract By getPriceWithDiscountLblLoc();

    protected abstract By getBrandNameLblLoc();

    protected abstract By getSellerNameLblLoc();

    protected abstract By getSellerCityLblLoc();

    public String getSellerNameBtnText() {
        return sellerNameLbl.getText();
    }

    public ProductScreen tapSellerNameBtn() {
        sellerNameLbl.click();
        return this;
    }

    public String getSellerCityBtnText() {
        return sellerCityLbl.getText();
    }

    public ProductModel getProductInfo() {
        ProductModel productModel = new ProductModel();
        productModel.setBrand(brandNameLbl.getText());
        productModel.setOriginalPrice(originalPriceLbl.getText());
        productModel.setDiscount(discountLbl.getText());
        productModel.setPriceWithDiscount(priceWithDiscountLbl.getText());
        return productModel;
    }
}
