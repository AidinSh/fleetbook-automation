package testCases;


import base.BaseClass;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChargerPage;
import pages.LoginPage;
import utils.Utils;

import java.net.MalformedURLException;

public class AuthenticationTests extends BaseClass {

    LoginPage loginPage;
    ChargerPage chargerPage;
    Utils utils;

    String Email = "user5@test.com";
    String password = "Bb1234567890!";

    public AuthenticationTests() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        loginPage = new LoginPage(driver);
        utils = new Utils();
    }

    @Test
    public void SuccessfulLoginTest(){
        loginPage.fillEmail(Email);
        loginPage.fillPassword(password);
        this.chargerPage = loginPage.tapLoginButton();
        Assert.assertTrue(utils.waitForElement(chargerPage.chargerTab, 10));
    }

}
