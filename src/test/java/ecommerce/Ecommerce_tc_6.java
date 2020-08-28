package ecommerce;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseApp;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;
import java.util.TreeMap;

public class Ecommerce_tc_6 {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        AndroidDriver<AndroidElement> driver = BaseApp.capabilities("real");
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Rahul");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(1000);
        TouchAction action=new TouchAction(driver);
        WebElement checkBox=driver.findElementByClassName("android.widget.CheckBox");
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkBox))).perform();
        WebElement longPressButton=driver.findElementById("com.androidsample.generalstore:id/termsButton");

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longPressButton)).withDuration(Duration.ofSeconds(2))).perform();

        String header=driver.findElementById("com.androidsample.generalstore:id/alertTitle").getText();
        Assert.assertEquals("Terms Of Conditions",header);
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(1000);
        Set<String> contexts=driver.getContextHandles();
        for (String context:contexts){
            System.out.println(context);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElementByXPath("//input[@name='q']").sendKeys("hello");
        driver.findElementByXPath("//input[@name='q']").sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");

    }
}
