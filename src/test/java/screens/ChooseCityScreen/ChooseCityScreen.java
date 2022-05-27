package screens.ChooseCityScreen;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class ChooseCityScreen extends Screen {
    protected final IButton dontShowAgainBtn;
    private final ITextBox searchTbx;
    private final IButton cityToChooseBtn;

    protected ChooseCityScreen(By locator) {
        super(locator, "Choose City Screen");
        dontShowAgainBtn = getElementFactory().getButton(getDontShowAgainBtn(), "Don't Show Again Button");
        searchTbx = getElementFactory().getTextBox(getSearchTbx(), "Search TextBox");
        cityToChooseBtn = getElementFactory().getButton(getCityToChooseBtn(), "City to Choose Button");
    }

    protected abstract By getDontShowAgainBtn();
    protected abstract By getSearchTbx();
    protected abstract By getCityToChooseBtn();

    public Boolean isDontShowAgainBtnDisplayed() {
        return dontShowAgainBtn.state().isDisplayed();
    }
    public ChooseCityScreen tapDontShowAgainBtn() {
        dontShowAgainBtn.click();
        return this;
    }

    public ChooseCityScreen fillInSearchTbx(String city) {
        searchTbx.sendKeys(city);
        return this;
    }

    public ChooseCityScreen tapCityToChooseBtn() {
        cityToChooseBtn.click();
        return this;
    }
}
