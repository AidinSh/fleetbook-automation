package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//android.widget.EditText[1]")
    MobileElement EmailField;

    @FindBy(xpath = "//android.widget.EditText[2]")
    MobileElement passwordField;

    @FindBy(xpath = "//android.widget.EditText/android.widget.Button")
    MobileElement showPassIcon;

    @FindBy(xpath = "//android.view.View/android.widget.Button[1]")
    MobileElement loginButton;

    @FindBy(xpath = "//android.widget.Button[2]")
    MobileElement forgetPasswordButton;

    @FindBy(xpath = "//android.widget.EditText/android.view.View")
    MobileElement EmailFieldErrorMsg;

    @FindBy(xpath = "//android.widget.EditText/android.view.View")
    MobileElement passwordFieldErrorMsg;

    public void fillEmail(String input){
        EmailField.sendKeys(input);
    }

    public void fillPassword(String input){
        passwordField.sendKeys(input);
    }

    public void showPassword(){
        showPassIcon.click();
    }

    public void forgotPass(){
        forgetPasswordButton.click();
    }


}
