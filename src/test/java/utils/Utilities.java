package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Utilities {
    public static AndroidDriver<AndroidElement> driver;

    public Utilities(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
    }

    public static void scrollToText(String intoView){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+intoView+"\"));");
    }

    public static void getScreenshot(String s) throws IOException {
       File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(scrFile,new File("/Users/kyialbekn/IdeaProjects/AppiumDemo/screenShots/"+s+".png"));

    }
}
