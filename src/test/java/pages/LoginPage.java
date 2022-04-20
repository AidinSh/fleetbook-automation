package pages;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage extends BaseClass {

    AppiumDriver<MobileElement> driver;

    public LoginPage(AppiumDriver<MobileElement> driver) throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        super();
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    MobileElement EmailField;

    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.EditText/android.widget.Button")
    MobileElement showPassIcon;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button[1]")
    MobileElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    MobileElement forgetPasswordButton;

    @AndroidFindBy(xpath = "//android.widget.EditText/android.view.View")
    MobileElement EmailFieldErrorMsg;

    @AndroidFindBy(xpath = "//android.widget.EditText/android.view.View")
    MobileElement passwordFieldErrorMsg;

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

    public void tapLoginButton(){
        loginButton.click();
    }

    public void showPassword(){
        showPassIcon.click();
    }

    public void forgotPass(){
        forgetPasswordButton.click();
    }




}
