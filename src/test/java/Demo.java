import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class Demo {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement>driver= HybridBase.capabilities("emulator");
    }
}
