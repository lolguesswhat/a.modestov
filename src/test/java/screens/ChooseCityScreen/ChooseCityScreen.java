package screens.ChooseCityScreen;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class ChooseCityScreen extends Screen {

    private final IButton dontShowAgainBtn;
    private final ITextBox searchTbx;

    protected ChooseCityScreen(By locator) {
        super(locator, "Choose City Screen");
        dontShowAgainBtn = getElementFactory().getButton(getDontShowAgainBtn(), "Don't Show Again Button");
        searchTbx = getElementFactory().getTextBox(getSearchTbx(), "Search TextBox");
    }

    protected abstract By getDontShowAgainBtn();

    protected abstract By getSearchTbx();

    protected abstract By getCityToChooseBtn(String city);

    public boolean isDontShowAgainBtnDisplayed() {
        return dontShowAgainBtn.state().waitForDisplayed();
    }

    public ChooseCityScreen tapDontShowAgainBtn() {
        dontShowAgainBtn.click();
        return this;
    }

    public ChooseCityScreen fillInSearchTbx(String city) {
        searchTbx.sendKeys(city);
        return this;
    }

    public ChooseCityScreen tapCityToChooseBtn(String city) {
        getElementFactory().getButton(getCityToChooseBtn(city), "City to Choose Button").click();
        return this;
    }
}
