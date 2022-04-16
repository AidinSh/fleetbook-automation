package testCases;

import base.BaseClass;
import io.testproject.sdk.drivers.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    LoginPage loginPage = new LoginPage();
    AndroidDriver driver;

    @BeforeClass
    public void initilize(){
        try{
            driver = getAndroidDriver();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void successfulLogin(){
        loginPage.fillEmail("user5@test.com");
        loginPage.fillPassword("Aa1234567890!");
    }

}
