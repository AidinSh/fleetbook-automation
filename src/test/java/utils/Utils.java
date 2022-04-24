package utils;

import base.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BaseClass {

    public Boolean waitForElement(MobileElement element, int timeOut){
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();

        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void swipeHorizontal(){
        Dimension screenSize = driver.manage().window().getSize();
        int startPoint = (int)(screenSize.width*0.9);
        int endPoint = (int)(screenSize.width*0.1);
        int height = (int)(screenSize.height/2);
        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(startPoint, height)).moveTo(PointOption.point(endPoint,height)).release().perform();
    }
}
