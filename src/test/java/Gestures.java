import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class Gestures {
    @Test
    public void pressAndHold() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver= BaseCap.capabilities();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        //Tap
        TouchAction t=new TouchAction(driver);
        WebElement expList=driver.findElementByXPath("//android.widget.TextView[@content-desc='Expandable Lists']");
        t.tap(tapOptions().withElement(ElementOption.element(expList))).perform();

        WebElement cusAdapter=driver.findElementByXPath("//android.widget.TextView[@content-desc='1. Custom Adapter']");
        t.tap(tapOptions().withElement(ElementOption.element(cusAdapter))).perform();
        WebElement peopleNames=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames)).withDuration(Duration.ofSeconds(3))).release().perform();
        Assert.assertTrue(driver.findElementById("android:id/title").isDisplayed());
    }
}
