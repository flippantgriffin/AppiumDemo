import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UIAutomatorTest {
    @Test
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver= BaseCap.capabilities();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElementByAndroidUIAutomator("attribute("value)");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size()+" "+
                driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size());
        System.out.println(driver.findElementsByXPath("//android.widget.TextView").size());
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));").click();
    }

}
