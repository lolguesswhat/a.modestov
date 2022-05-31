package screens.ChooseCityScreen;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class ChooseCityScreen extends Screen {

    private final IButton doNotShowAgainBtn;
    private final ITextBox searchTbx;

    protected ChooseCityScreen(By locator) {
        super(locator, "Choose City Screen");
        doNotShowAgainBtn = getElementFactory().getButton(getDoNotShowAgainBtnLoc(), "Don't Show Again Button");
        searchTbx = getElementFactory().getTextBox(getSearchTbxLoc(), "Search TextBox");
    }

    protected abstract By getDoNotShowAgainBtnLoc();

    protected abstract By getSearchTbxLoc();

    protected abstract By getCityToChooseBtnLoc(String city);

    public boolean isDoNotShowAgainBtnDisplayed() {
        return doNotShowAgainBtn.state().waitForDisplayed();
    }

    public ChooseCityScreen tapDontShowAgainBtn() {
        doNotShowAgainBtn.click();
        return this;
    }

    public ChooseCityScreen fillInSearchTbx(String city) {
        searchTbx.sendKeys(city);
        return this;
    }

    public ChooseCityScreen tapSearchBtn(String city) {
        getElementFactory().getButton(getCityToChooseBtnLoc(city), "City to Choose Button").click();
        return this;
    }
}
