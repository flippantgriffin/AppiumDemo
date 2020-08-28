package gestures;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.net.MalformedURLException;

public class ScrollDemo {
    AndroidDriver<AndroidElement> driver;
    @Test
    public void miscellaneous() throws MalformedURLException {
        driver=CommonUtils.getAndroidDriver("emulator");
        System.out.println(driver.currentActivity());// current app page
        System.out.println(driver.getContext());  //NATIVE_APP or Hybrid_app
        System.out.println(driver.getOrientation()); // PORTRAIT
        System.out.println(driver.isDeviceLocked()); // locked or not locked
        driver.navigate().back();

    }
    @Test
    public void scrollDown() throws MalformedURLException {
        driver= CommonUtils.getAndroidDriver("emulator");
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        // Appium not support scroll method
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"))").click();
    }

}
