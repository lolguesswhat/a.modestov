package screens.MainScreen;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class MainScreen extends Screen {
    private final IButton chooseCityBtn;

    protected MainScreen(By locator) {
        super(locator, "Main Screen");
        chooseCityBtn = getElementFactory().getButton(getChooseCityBtn(), "Choose City Button");
    }

    protected abstract By getChooseCityBtn();

    public MainScreen tapChooseCityBtn() {
        chooseCityBtn.click();
        return this;
    }

    public String getChooseCityBtnText() {
        return chooseCityBtn.getAttribute("text");
    }


}
