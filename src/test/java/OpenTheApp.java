import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.cucumber.java.hu.De;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import javax.xml.datatype.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OpenTheApp {

    String skipButtonXpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Button";
    String profileButton = "//android.view.View[5]/android.view.View[5]";
    String searchBox = "//android.widget.EditText";

    String DevToken = "ZjuIfVde9ZdSPyNP-I9w17zVhn5b_l0A26zPl0iPCl41";
    DesiredCapabilities cap = new DesiredCapabilities();

    public OpenTheApp() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
    }

    public DesiredCapabilities setCap(DesiredCapabilities cap) {
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.UDID, "ZY227WMPN6");
        cap.setCapability(MobileCapabilityType.APP, "fleet.app.test");

        return cap;
    }

    //AndroidDriver driver = new AndroidDriver(DevToken, setCap(cap));

    AndroidDriver driver = new DriverBuilder<AndroidDriver>(setCap(cap))
            .withToken(DevToken)
            .withRemoteAddress(new URL("http://localhost:8585"))
            .build(AndroidDriver.class);

    @Test
    public void openApp() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath(skipButtonXpath).click();
        driver.findElementByXPath(searchBox).sendKeys("berlin");
    }

}
