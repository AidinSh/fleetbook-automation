package testCases;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest extends BaseClass {
    LoginPage loginPage;

    public LoginTest() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void successfulLogin(){
        loginPage.fillEmail("aidin.shahmoradi@fakir-it.de");
        loginPage.fillPassword("Aa1234567890!");
        loginPage.tapLoginButton();
    }

}
