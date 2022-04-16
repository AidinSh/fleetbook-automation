import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.drivers.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.sql.Driver;

public class BaseClass {
    String developerToken = "";
    String remoteAddress = "";

    DesiredCapabilities capabilities = new DesiredCapabilities();

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
