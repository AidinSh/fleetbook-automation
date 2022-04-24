package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    AppiumDriver<MobileElement> driver;

    public ProfilePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[3]/android.view.View[1]/android.view.View[5]/android.view.View")
    MobileElement logOutButton;

    public LoginPage logOut(){
        logOutButton.click();
        return new LoginPage(driver);
    }
}
