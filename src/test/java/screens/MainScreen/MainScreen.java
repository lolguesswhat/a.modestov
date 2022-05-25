package screens.MainScreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class MainScreen extends Screen {
    private final IButton chooseCityBtn;
    private final IButton brandNameBtn;
    private final IButton oldPriceBtn;
    private final IButton discountBtn;
    private final IButton priceWithDiscountBtn;
    private final IButton productBtn;


    protected MainScreen(By locator) {
        super(locator, "Main Screen");
        chooseCityBtn = getElementFactory().getButton(getChooseCityBtn(), "Choose City");
        brandNameBtn = getElementFactory().getButton(getBrandNameBtn(), "Brand Name");
        oldPriceBtn = getElementFactory().getButton(getOldPriceBtn(), "Old Price");
        discountBtn = getElementFactory().getButton(getDiscountBtn(), "Discount");
        priceWithDiscountBtn = getElementFactory().getButton(getPriceWithDiscountBtn(), "Price With Discount");
        productBtn = getElementFactory().getButton(getProductBtn(), "Product Button");

    }

    protected abstract By getChooseCityBtn();
    protected abstract By getBrandNameBtn();
    protected abstract By getOldPriceBtn();
    protected abstract By getDiscountBtn();
    protected abstract By getPriceWithDiscountBtn();
    protected abstract By getProductBtn();


    public MainScreen tapChooseCityBtn() {
        chooseCityBtn.click();
        return this;
    }

    public String getChooseCityBtnText() {
        return chooseCityBtn.getText();
    }
    public void waitForCityToChange() {
        new WebDriverWait(AqualityServices.getApplication().getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.attributeToBe(getChooseCityBtn(), "text", "Madrid"));
    }

    public String getBrandBtnText() {
        return brandNameBtn.getText();
    }

    public String getOldPriceBtnText() {
        return oldPriceBtn.getText();
    }

    public String getDiscountBtnText() {
        return discountBtn.getText();
    }

    public String getPriceWithDiscountBtnText() {
        return priceWithDiscountBtn.getText();
    }

    public MainScreen tapProductBtn() {
        productBtn.click();
        return this;
    }



}
