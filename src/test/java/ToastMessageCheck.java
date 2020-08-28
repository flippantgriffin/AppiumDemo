import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseApp;

import java.net.MalformedURLException;

public class ToastMessageCheck {
    @Test
    public  void toastMessage() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver= BaseApp.capabilities("emulator");
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        Assert.assertEquals("Please enter your name",toastMessage);
    }
}
