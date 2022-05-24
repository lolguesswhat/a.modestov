package tests;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ChooseCityScreen.ChooseCityScreen;
import screens.MainScreen.MainScreen;
import screens.ProductScreen.ProductScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class Task1 extends BaseTest {
@Test
    public void test1() throws MalformedURLException {
    AndroidDriver driver;
    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability("deviceName", "Redmi Note 7");
    cap.setCapability("automationName", "UiAutomator2");
    cap.setCapability("udid", "94e4ca68");
    cap.setCapability("platformName", "Android");
    cap.setCapability("platformVersion", "10");

    cap.setCapability("appPackage", "com.coffeebeanventures.easyvoicerecorder");
    cap.setCapability("appActivity", "com.digipom.easyvoicerecorder.ui.activity");
    URL url = new URL("http://127.0.0.1:4723/");
    driver = new AndroidDriver(url, cap);

}
@Test
    public void test2() throws InterruptedException {
    //Step 1
    MainScreen mainScreen = AqualityServices.getScreenFactory().getScreen(MainScreen.class);
    Assert.assertTrue(mainScreen.state().isDisplayed(),"arfgaerg");
    mainScreen.tapChooseCityBtn();

    ChooseCityScreen chooseCityScreen = AqualityServices.getScreenFactory().getScreen(ChooseCityScreen.class);
    Assert.assertTrue(chooseCityScreen.state().isDisplayed(),"aergaerg");

    //Step 2
    chooseCityScreen.fillInSearchTbx("Madrid");

    //Step 3
    chooseCityScreen.tapCityToChooseBtn();

    //Step 4
    Assert.assertEquals(mainScreen.getChooseCityBtnText(), "Madrid", "drfgadrg");

    //Step 5!!!!!!!!!!!!!!!!!!!!
    IButton btn = AqualityServices.getElementFactory().getButton(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]"), "");
    
    IButton brandNameBtn = AqualityServices.getElementFactory().getButton(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvBrand']"), "");
    String brandName = btn.getText();

    IButton priceBtn = AqualityServices.getElementFactory().getButton(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvPrice']"), "");
    String salePrice = priceBtn.getText();

    IButton oldPriceBtn = AqualityServices.getElementFactory().getButton(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvSumm']"), "");
    String oldPrice = oldPriceBtn.getText();

    IButton discountBtn = AqualityServices.getElementFactory().getButton(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvDiscount']"), "");
    String discount = discountBtn.getText();







    btn.click();
    ProductScreen productScreen = AqualityServices.getScreenFactory().getScreen(ProductScreen.class);
    Assert.assertNotNull(productScreen, "");


    //Step 6
    Assert.assertEquals(brandName, productScreen.getBrandBtnText(), "");
    Assert.assertEquals(salePrice, productScreen.getSalePriceBtnText(), "");

    //Step 7 Check that old price, discount and price with discount are correct
    Assert.assertEquals(oldPrice, " ", "");

    //Step 8. Click on seller
    //Step 9. Check that seller information is correct (name, city)








}
}
