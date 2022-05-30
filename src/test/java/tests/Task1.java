package tests;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import models.ProductModel;
import models.SellerModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ChooseCityScreen.ChooseCityScreen;
import screens.MainScreen.MainScreen;
import screens.ProductScreen.ProductScreen;
import screens.SellerScreen.SellerScreen;

import java.util.List;


public class Task1 extends BaseTest {

    private static final ISettingsFile testData = new JsonSettingsFile("testData.json");
    private static final String CITY_TO_CHOOSE = testData.getValue("/cityToChoose").toString();
    private static final int PRODUCT_TO_CHOOSE = Integer.parseInt(testData.getValue("/productToChoose").toString());

    @Test
    public void test1() {
        //Step 1 Click on city label
        MainScreen mainScreen = AqualityServices.getScreenFactory().getScreen(MainScreen.class);
        Assert.assertTrue(mainScreen.state().isDisplayed(), "Main Screen is not displayed");
        mainScreen.tapChooseCityBtn();
        ChooseCityScreen chooseCityScreen = AqualityServices.getScreenFactory().getScreen(ChooseCityScreen.class);
        Assert.assertTrue(chooseCityScreen.isDontShowAgainBtnDisplayed(), "Pop-Up has not shown up");
        chooseCityScreen.tapDontShowAgainBtn();
        Assert.assertFalse(chooseCityScreen.isDontShowAgainBtnDisplayed(), "Pop-Up has not disappeared");
        Assert.assertTrue(chooseCityScreen.state().isDisplayed(), "Choose City Screen in not displayed");

        //Step 2. Type 'Los Angeles' in search field
        chooseCityScreen.fillInSearchTbx(CITY_TO_CHOOSE);

        //Step 3. Click on search result 'Los Angeles, CA'
        chooseCityScreen.tapCityToChooseBtn(CITY_TO_CHOOSE);
        Assert.assertTrue(mainScreen.state().waitForDisplayed(), "Main Screen is not displayed");

        //Step 4. Check 'L.Angeles' is selected as region
        mainScreen.waitForCityToChange(CITY_TO_CHOOSE);
        Assert.assertEquals(mainScreen.getChooseCityBtnText(), CITY_TO_CHOOSE, "Required region does not match required value");

        //Step 5. Select first item with discount
        ProductModel productFromListCityScreen = mainScreen.getProductInfo(PRODUCT_TO_CHOOSE);
        mainScreen.tapProductBtn(PRODUCT_TO_CHOOSE);
        ProductScreen productScreen = AqualityServices.getScreenFactory().getScreen(ProductScreen.class);
        Assert.assertNotNull(productScreen, "Product Screen is not displayed");

        //Step 6 and 7
        ProductModel productFromProductScreen = productScreen.getProductInfo();
        Assert.assertEquals(productFromListCityScreen, productFromProductScreen, "sefawserf");

        //Step 8. Click on seller
        SellerModel sellerFromProductScreen = new SellerModel();
        sellerFromProductScreen.setSellerName(productScreen.getSellerNameBtnText());
        sellerFromProductScreen.setSellerCity(productScreen.getSellerCityBtnText());
        productScreen.tapSellerNameBtn();
        SellerScreen sellerScreen = AqualityServices.getScreenFactory().getScreen(SellerScreen.class);
        Assert.assertTrue(sellerScreen.state().waitForDisplayed(), "Seller Screen is not displayed");

        //Step 9. Check that seller information is correct (name, city)
        SellerModel sellerFromSellerScreen = new SellerModel();
        sellerFromSellerScreen.setSellerName(sellerScreen.getSellerNameBtnText());
        sellerFromSellerScreen.setSellerCity(sellerScreen.getSellerCityBtnText());
        Assert.assertEquals(sellerFromProductScreen, sellerFromSellerScreen, "safdafg");
    }
}
