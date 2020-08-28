package gestures;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.net.MalformedURLException;

public class DragAndDrop {
    AndroidDriver<AndroidElement> driver;
    @Test
    public void dragAndDrop() throws MalformedURLException {
        driver= CommonUtils.getAndroidDriver("emulator");
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]").click();
        TouchAction action=new TouchAction(driver);
        // longpress(source)/move(destination)//
        WebElement source=driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        WebElement destination=driver.findElementById("io.appium.android.apis:id/drag_dot_2");
        action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(destination)).release().perform();
    }

}
