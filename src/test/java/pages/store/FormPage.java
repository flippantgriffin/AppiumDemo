package pages.store;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement genderFemale;

    @AndroidFindBy(id="android:id/text1")
    public WebElement countrySelection;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement shopButton;
    public WebElement getNameField(){
        return nameField;
    }

}
