package ecommerce;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BaseApp;

import java.net.MalformedURLException;

public class Ecommerce_tc_2 {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement>driver=BaseApp.capabilities("emulator");
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Rahul");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[@text='Female']").click();
        //driver.findElementById("android:id/text1").click();
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahamas\"));");
//        driver.findElementByXPath("//*[@text='Bahamas']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0; i<=count;i++){
            String expShoes=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(expShoes.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(1000);

        String lastPageText  =    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

        Assert.assertEquals("Jordan 6 Rings", lastPageText, "here is the fail");
    }
}
