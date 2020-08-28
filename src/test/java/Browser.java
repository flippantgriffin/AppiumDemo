import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Browser {
    @Test
    public void browser() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=BaseChrome.getAndroidDriver("real");
//        driver.get("https://www.facebook.com/");
//        driver.findElementById("m_login_email").sendKeys("qwerty");
//        driver.findElementById("m_login_password").sendKeys("12345");
//        driver.findElementByXPath("//button[@value='Log In']").click();
        driver.get("http://cricbuzz.com");
        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
        System.out.println(driver.getCurrentUrl());
        /*
        If device is unauthorized
        go to terminal check
        adb devices -Unauthorized
        hit this three commands
        adb kill-server
        adb start-server
        adb devices

         */

    }
}
