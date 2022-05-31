package screens.MainScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import constants.TimeoutConstants;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class MainScreen extends Screen {

    private final IButton chooseCityBtn;

    protected MainScreen(By locator) {
        super(locator, "Main Screen");
        chooseCityBtn = getElementFactory().getButton(getChooseCityBtnLoc(), "Choose City");
    }

    protected abstract By getChooseCityBtnLoc();

    protected abstract By getBrandNameLblLoc();

    protected abstract By getOriginalPriceLblLoc();

    protected abstract By getDiscountLblLoc();

    protected abstract By getPriceWithDiscountLblLoc();

    protected abstract By getProductBtnLoc();

    public MainScreen tapChooseCityBtn() {
        chooseCityBtn.click();
        return this;
    }

    public String getChooseCityBtnText() {
        return chooseCityBtn.getText();
    }

    public void waitForCityToChange(String requiredCity) {
        new WebDriverWait(AqualityServices.getApplication().getDriver(),
                Duration.ofSeconds(TimeoutConstants.WAIT_FOR_CITY_TO_CHANGE_TIMEOUT))
                .until(ExpectedConditions.attributeToBe(getChooseCityBtnLoc(), "text", requiredCity));
    }

    public MainScreen tapProductBtn(int index) {
        IButton product = (IButton) AqualityServices.getElementFactory().findElements(getProductBtnLoc(),
                ElementType.BUTTON).get(--index);
        product.click();
        return this;
    }

    public ProductModel getProductInfo(int index) {
        IButton product = (IButton) AqualityServices.getElementFactory().findElements(getProductBtnLoc(),
                ElementType.BUTTON).get(--index);
        ProductModel productModel = new ProductModel();
        productModel.setBrand(product.findChildElement(getBrandNameLblLoc(), ElementType.BUTTON).getText());
        productModel.setOriginalPrice(product.findChildElement(getOriginalPriceLblLoc(), ElementType.BUTTON).getText());
        productModel.setDiscount(product.findChildElement(getDiscountLblLoc(), ElementType.BUTTON).getText());
        productModel.setPriceWithDiscount(product.findChildElement(getPriceWithDiscountLblLoc(), ElementType.BUTTON).getText());
        return productModel;
    }

    public int getFirstProductWithDiscount() {
        List<IButton> listOfProducts = AqualityServices.getElementFactory().findElements(getProductBtnLoc(), ElementType.BUTTON);
        int productSerialNumber = 0;
        for (int productIndex = 0; productIndex < listOfProducts.size(); productIndex++) {
            if (listOfProducts.get(productIndex).findChildElements(getDiscountLblLoc(), IButton.class).size() > 0) {
                productSerialNumber = ++productIndex;
                break;
            }
        }
        return productSerialNumber;
    }
}

