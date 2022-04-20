package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.drivers.ios.IOSDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

public class BaseClass {
    String developerToken = "ZjuIfVde9ZdSPyNP-I9w17zVhn5b_l0A26zPl0iPCl41";
    String remoteAddress = "http://localhost:8585";
    public static AppiumDriver<MobileElement> driver;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    public BaseClass() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.UDID, "ZY227WMPN6");
        //capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "fleet.app.test");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.fleet_manager_app.MainActivity");
        //capabilities.setCapability(MobileCapabilityType.APP, "fleet.app.test");
        try {
            driver = new AndroidDriver<>(developerToken, capabilities);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
