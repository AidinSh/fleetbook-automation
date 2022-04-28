package testCases;


import Qase.RequestMaker;
import Qase.Requests;
import base.BaseClass;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Utils;

import java.net.MalformedURLException;

public class AuthenticationTests extends BaseClass {

    //Pages
    LoginPage loginPage;
    ChargerPage chargerPage;
    OnboardingPage onboardingPage;
    NavBar navBar;
    ProfilePage profilePage;
    Utils utils;

    Requests requests;
    RequestMaker requestMaker =  new RequestMaker();;

    //Credentials
    String Email = "user5@test.com";
    String password = "Bb1234567890!";

    public AuthenticationTests() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        onboardingPage = new OnboardingPage(driver);
        loginPage = new LoginPage(driver);
        navBar = new NavBar(driver);
        profilePage = new ProfilePage(driver);
        utils = new Utils();

        requests = new Requests();

    }

    @Test(enabled = false)
    public void successfulFirstTimeLoginTest(){
        driver.resetApp();
        loginPage = onboardingPage.skipOnBoardingScreen();
        loginPage.fillEmail(Email);
        loginPage.fillPassword(password);
        this.chargerPage = loginPage.tapLoginButton();
        Assert.assertTrue(utils.waitForElement(chargerPage.chargerTab, 10));
    }

    @Test(enabled = true, priority = 1)
    public void successfulLogin(){
        String caseId = "1";

        loginPage.fillEmail(Email);
        loginPage.fillPassword(password);
        this.chargerPage = loginPage.tapLoginButton();

        boolean isPassed = utils.waitForElement(chargerPage.chargerTab, 10);
        if (isPassed){
            requestMaker.setRunResult(caseId, "passed", "");
            Assert.assertTrue(isPassed);
        }else {
            requestMaker.setRunResult(caseId, "failed", "Login Just Failed!!!");
            Assert.assertTrue(isPassed);
        }
    }

    @Test(priority = 2)
    public void logOutTest(){
        navBar.selectProfileTab();
        loginPage = profilePage.logOut();
        Assert.assertTrue(utils.waitForElement(loginPage.EmailField, 10));
    }

}
