package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    AppiumDriver<MobileElement> driver;

    public LoginPage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    public MobileElement EmailField;

    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    public MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.EditText/android.widget.Button")
    public MobileElement showPassIcon;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button[1]")
    public MobileElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    public MobileElement forgetPasswordButton;

    @AndroidFindBy(xpath = "//android.widget.EditText/android.view.View")
    public MobileElement EmailFieldErrorMsg;

    @AndroidFindBy(xpath = "//android.widget.EditText/android.view.View")
    public MobileElement passwordFieldErrorMsg;

    public void fillEmail(String input){
        EmailField.click();
        EmailField.sendKeys(input);
        driver.hideKeyboard();
    }

    public void fillPassword(String input){
        passwordField.click();
        passwordField.sendKeys(input);
        driver.hideKeyboard();
    }

    public ChargerPage tapLoginButton(){
        loginButton.click();
        return new ChargerPage(driver);
    }

    public void showPassword(){
        showPassIcon.click();
    }

    public void forgotPass(){
        forgetPasswordButton.click();
    }




}
