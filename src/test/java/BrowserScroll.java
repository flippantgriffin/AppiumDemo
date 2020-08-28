import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;

public class BrowserScroll {
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver=BaseChrome.getAndroidDriver("real");
        driver.get("http://cricbuzz.com");
        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,480)","");
        Assert.assertTrue(driver.findElementByXPath("//h4[text()='Top Stories']").getAttribute("class").contains("header"));
    }
}
