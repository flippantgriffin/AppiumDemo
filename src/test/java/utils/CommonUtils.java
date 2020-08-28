package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


    public class CommonUtils {

        static AndroidDriver<AndroidElement> driver;

        public static AndroidDriver<AndroidElement> getAndroidDriver(String device) throws MalformedURLException {
            File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
            DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
            if(device.equals("emulator")){
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel2");
            }else if(device.equals("real")){
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
            }
            desiredCapabilities.setPlatform(Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
            if(driver==null) {
                URL url = new URL("http:/localhost:4723/wd/hub");
                driver = new AndroidDriver<AndroidElement>(url, desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
            return driver;
        }


}
