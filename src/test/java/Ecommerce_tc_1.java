import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseApp;

import java.net.MalformedURLException;

public class Ecommerce_tc_1 {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement>driver= BaseApp.capabilities("emulator");
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Rahul");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahamas\"));");
        driver.findElementByXPath("//*[@text='Bahamas']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
    }
}
