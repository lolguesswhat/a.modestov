package screens.MainScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class MainScreen extends Screen {

    private final IButton chooseCityBtn;
    private final ILabel brandNameLbl;
    private final ILabel originalPriceLbl;
    private final ILabel discountLbl;
    private final ILabel priceWithDiscountLbl;
    private final IButton productBtn;

    protected MainScreen(By locator) {
        super(locator, "Main Screen");
        chooseCityBtn = getElementFactory().getButton(getChooseCityBtnLoc(), "Choose City");
        brandNameLbl = getElementFactory().getLabel(getBrandNameLblLoc(), "Brand name");
        originalPriceLbl = getElementFactory().getLabel(getOriginalPriceLblLoc(), "Old Price");
        discountLbl = getElementFactory().getLabel(getDiscountLblLoc(), "Discount");
        priceWithDiscountLbl = getElementFactory().getLabel(getPriceWithDiscountLblLoc(), "Price With Discount");
        productBtn = getElementFactory().getButton(getProductBtn(), "Product Button");
    }

    protected abstract By getChooseCityBtnLoc();

    protected abstract By getBrandNameLblLoc();

    protected abstract By getOriginalPriceLblLoc();

    protected abstract By getDiscountLblLoc();

    protected abstract By getPriceWithDiscountLblLoc();

    protected abstract By getProductBtn();

    public MainScreen tapChooseCityBtn() {
        chooseCityBtn.click();
        return this;
    }

    public String getChooseCityBtnText() {
        return chooseCityBtn.getText();
    }

    public void waitForCityToChange(String requiredCity) {
        new WebDriverWait(AqualityServices.getApplication().getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.attributeToBe(getChooseCityBtnLoc(), "text", requiredCity));
    }

    public MainScreen tapProductBtn(int index) {
        IButton product = (IButton) AqualityServices.getElementFactory().findElements(getProductBtn(), ElementType.BUTTON).get(--index);
        product.click();
        return this;
    }

    public ProductModel getProductInfo(int index) {
        IButton product = (IButton) AqualityServices.getElementFactory().findElements(getProductBtn(), ElementType.BUTTON).get(--index);
        ProductModel productModel = new ProductModel();
        productModel.setBrand(product.findChildElement(getBrandNameLblLoc(), ElementType.BUTTON).getText());
        productModel.setOriginalPrice(product.findChildElement(getOriginalPriceLblLoc(), ElementType.BUTTON).getText());
        productModel.setDiscount(product.findChildElement(getDiscountLblLoc(), ElementType.BUTTON).getText());
        productModel.setPriceWithDiscount(product.findChildElement(getPriceWithDiscountLblLoc(), ElementType.BUTTON).getText());
        return productModel;
    }
}
