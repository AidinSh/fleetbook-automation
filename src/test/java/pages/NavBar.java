package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NavBar {

    AppiumDriver<MobileElement> driver;

    public NavBar(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[5]")
    MobileElement profileButton;

    public ProfilePage selectProfileTab(){
        profileButton.click();
        return new ProfilePage(driver);
    }

}
