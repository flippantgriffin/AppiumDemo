import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Base;

import java.io.IOException;
import java.net.MalformedURLException;

public class ApiDemos {

    @BeforeTest
    public void killAllNodes() throws IOException {
        // taskkill /F /IM node.exe
        Runtime.getRuntime().exec("killall node");
    }

    @Test(dataProvider = "InputData", dataProviderClass = TestData.class)
    public void apiDemo(String input) throws IOException, InterruptedException {

        AppiumDriverLocalService service=Base.startServer();
        service.start();

        AndroidDriver<AndroidElement> driver = Base.capabilities("ApiDemo");
        /*
        Xpath  id className, androidUIAutomator
        xpath syntax
        // tagName[@attribute='value']

         */
        AndroidElement preference = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
        preference.click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath( "(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(input);
        //driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
        driver.findElementsByClassName("android.widget.Button").get(1).click();
        service.stop();
    }


}
