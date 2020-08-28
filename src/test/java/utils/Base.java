package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static AppiumDriverLocalService service;

    public static AppiumDriverLocalService startServer(){
        // this class will hwlp us to run server
        boolean flag = checkIfServerIsRunning(4723);
        if(!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
       return service;
    }

    public static boolean checkIfServerIsRunning(int port){
        boolean isServerRunning=false;
        ServerSocket serverSocket;
        try{
            serverSocket =new ServerSocket(port);
            serverSocket.close();
        }catch (IOException e){
            // If control comes to here , then it means that the port is in use
            isServerRunning=true;
        }finally {
            serverSocket=null;
        }
        return isServerRunning;

    }



    public static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
//        File f=new File("src");
//        File fs=new File(f,"ApiDemos-debug.apk");
        FileInputStream fileInputStream=new FileInputStream("/Users/kyialbekn/IdeaProjects/AppiumDemo/src/test/resources/global.properties");
        Properties properties=new Properties();
        properties.load(fileInputStream);

        File file=new File("src/test/resources/"+properties.get(appName));

        DesiredCapabilities cap=new DesiredCapabilities();
        //String device=(String) properties.get("device");
        String device=System.getProperty("deviceName");
        if(device.contains("Pixel2")){
            startEmulator();
        }

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        cap.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());


        URL url=new URL("http:/localhost:4723/wd/hub");
        driver=new AndroidDriver<>(url,cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return  driver;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("/Users/kyialbekn/IdeaProjects/AppiumDemo/src/test/resources/startEmulatorPixel2");
        Thread.sleep(6000);
    }
}
