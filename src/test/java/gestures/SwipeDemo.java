package gestures;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonUtils;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;


public class SwipeDemo {
    AndroidDriver<AndroidElement> driver;
    @Test
    public void swipe() throws MalformedURLException {
        driver= CommonUtils.getAndroidDriver("emulator");
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        //Tap
        TouchAction t=new TouchAction(driver);
        WebElement dateWidgets=driver.findElementByXPath("//android.widget.TextView[@content-desc='Date Widgets']");
        t.tap(tapOptions().withElement(ElementOption.element(dateWidgets))).perform();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='9']").click();
        // long press  on element 2 sec move to another element and you release
        WebElement first=driver.findElementByXPath("//*[@content-desc=\"15\"]");
        WebElement second=driver.findElementByXPath("//*[@content-desc=\"45\"]");
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(first)).withDuration(ofSeconds(2)))
                .moveTo(ElementOption.element(second)).release().perform();

    }

}
