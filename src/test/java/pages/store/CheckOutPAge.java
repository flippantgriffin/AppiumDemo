package pages.store;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPAge {
    public CheckOutPAge(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(xpath="//*[@text='Bahamas']")
    public WebElement countrySelection;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalAmount;

}
