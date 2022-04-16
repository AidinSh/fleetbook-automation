package base;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.drivers.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.sql.Driver;

public class BaseClass {
    String developerToken = "ZjuIfVde9ZdSPyNP-I9w17zVhn5b_l0A26zPl0iPCl41";
    String remoteAddress = "http://localhost:8585";

    DesiredCapabilities capabilities = new DesiredCapabilities();

    public BaseClass(){
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.UDID, "ZY227WMPN6");
        capabilities.setCapability(MobileCapabilityType.APP, "fleet.app.test");
    }

    public AndroidDriver getAndroidDriver() throws Exception{

        return new DriverBuilder<AndroidDriver>(capabilities)
                .withToken(developerToken)
                .withRemoteAddress(new URL(remoteAddress))
                .build(AndroidDriver.class);
    }

    public IOSDriver getIOSDriver() throws Exception{

        return new DriverBuilder<IOSDriver>(capabilities)
                .withToken(developerToken)
                .withRemoteAddress(new URL(remoteAddress))
                .build(IOSDriver.class);

    }
}
