package utils;

import base.BaseClass;
import io.appium.java_client.MobileElement;
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
}
