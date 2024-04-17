package views;

import base.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import support.Utilities;

public class CallView extends Base {

    private final By endCallButton = AppiumBy.accessibilityId("End call");

//    Utilities utilities = new Utilities();

    public MainView endCall(){

//        utilities.getElement(endCallButton).click();

        driver.findElement(endCallButton).click();

        return new MainView();
    }
}
