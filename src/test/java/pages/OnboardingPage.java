package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.testproject.sdk.drivers.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class OnboardingPage {

    AppiumDriver<MobileElement> driver;
    Utils utils;

    public OnboardingPage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        utils = new Utils();
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Skip']")
    MobileElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Get Started']")
    MobileElement getStartedButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Accept']")
    MobileElement acceptDataPrivacyButton;

    public LoginPage skipOnBoardingScreen(){
        utils.swipeHorizontal();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        utils.swipeHorizontal();
        getStartedButton.click();
        acceptDataPrivacyButton.click();
        return new LoginPage(driver);
    }
}
