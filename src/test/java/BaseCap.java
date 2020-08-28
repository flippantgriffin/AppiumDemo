import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseCap {
    public static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
//        File f=new File("src");
//        File fs=new File(f,"ApiDemos-debug.apk");
        File file=new File("src/test/resources/ApiDemos-debug.apk");

        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        cap.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());


        URL url=new URL("http:/localhost:4723/wd/hub");
        driver=new AndroidDriver<>(url,cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return  driver;
    }
}
