package tests;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ChooseCityScreen.ChooseCityScreen;
import screens.MainScreen.MainScreen;
import screens.ProductScreen.ProductScreen;
import screens.SellerScreen.SellerScreen;


public class Task1 extends BaseTest {
    private static final ISettingsFile testData = new JsonSettingsFile("testData.json");
    private static final String CITY_TO_CHOOSE = testData.getValue("/cityToChoose").toString();

    @Test
    public void test2() {
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
        chooseCityScreen.tapCityToChooseBtn();
        Assert.assertTrue(mainScreen.state().waitForDisplayed(), "Main Screen is not displayed");

        //Step 4. Check 'L.Angeles' is selected as region
        mainScreen.waitForCityToChange(CITY_TO_CHOOSE);
        Assert.assertEquals(mainScreen.getChooseCityBtnText(), CITY_TO_CHOOSE, "Required region does not match required value");

        //Step 5. Select first item with discount
        String brandName = mainScreen.getBrandBtnText();
        String oldPrice = mainScreen.getOldPriceBtnText();
        String discount = mainScreen.getDiscountBtnText();
        String priceWithDiscount = mainScreen.getPriceWithDiscountBtnText();
        mainScreen.tapProductBtn();
        ProductScreen productScreen = AqualityServices.getScreenFactory().getScreen(ProductScreen.class);
        Assert.assertNotNull(productScreen, "Product Screen is not displayed");

        //Step 6
        Assert.assertEquals(productScreen.getBrandBtnText(), brandName, "Brand Name does not match previous value");

        //Step 7 Check that old price, discount and price with discount are correct
        Assert.assertEquals(productScreen.getOldPriceBtnText(), oldPrice, "Old price does not match previous value");
        Assert.assertEquals(productScreen.getDiscountBtnText(), discount, "Discount does not match previous value");
        Assert.assertEquals(productScreen.getPriceWithDiscountBtnText(), priceWithDiscount, "Price with discount does not match previous value");

        //Step 8. Click on seller
        String sellerName = productScreen.getSellerNameBtnText();
        String sellerCity = productScreen.getSellerCityBtnText();
        productScreen.tapSellerNameBtn();
        SellerScreen sellerScreen = AqualityServices.getScreenFactory().getScreen(SellerScreen.class);
        Assert.assertTrue(sellerScreen.state().isDisplayed(), "Seller Screen is not displayed");

        //Step 9. Check that seller information is correct (name, city)
        Assert.assertEquals(sellerName, sellerScreen.getSellerNameBtnText(), "Seller name does not match previous value");
        Assert.assertEquals(sellerCity, sellerScreen.getSellerCityBtnText(), "Seller city does not match previous value");
    }
}
