package ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.store.CheckOutPAge;
import pages.store.FormPage;
import utils.Base;
import utils.BaseApp;
import utils.Utilities;

import java.io.IOException;
import java.net.MalformedURLException;

public class Ecommerce_tc_4 {

    @BeforeTest
    public void killAllNodes() throws IOException {
        // taskkill /F /IM node.exe
        Runtime.getRuntime().exec("killall node");
    }


    @Test
    public  void totalValidation() throws IOException, InterruptedException {


        AppiumDriverLocalService service=Base.startServer();
        service.start();
        AndroidDriver<AndroidElement> driver = Base.capabilities("GeneralStoreApp");
        FormPage formPage=new FormPage(driver);
        formPage.nameField.sendKeys("Rahul");
        driver.hideKeyboard();
        formPage.genderFemale.click();
        formPage.countrySelection.click();
        Utilities utilities=new Utilities(driver);
        utilities.scrollToText("Argentina");
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahamas\"));");
        driver.findElementByXPath("//*[@text='Argentina']").click();
        formPage.shopButton.click();
        for(int i=0;i<2;i++) {
            driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        Thread.sleep(1000);

        double sum=0;
        CheckOutPAge checkOutPAge=new CheckOutPAge(driver);

        int count=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
        for(int i=0; i<count; i++) {
            String amount1 = checkOutPAge.productList.get(i).getText();
            double amount = getAmount(amount1);
            System.out.println(amount);
            sum=sum+amount;
        }

        System.out.println(sum+" sum of Products");


        String totalSum= checkOutPAge.totalAmount.getText();
        double totalSumDouble=getAmount(totalSum);
        System.out.println(totalSumDouble+" Total of Products ");
        Assert.assertEquals(totalSumDouble,sum, 0.0);
        service.stop();

    }

    public static double getAmount(String value){
        value=value.substring(1);
        double amount1Double=Double.parseDouble(value);
        return amount1Double;
    }
}
