package views;

import base.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MainView extends Base {

    private final By dialer = AppiumBy.accessibilityId("key pad");

//    Utilities utilities = new Utilities();

    public DialerView openDialer(){

//        utilities.getElement(dialer).click();

        driver.findElement(dialer).click();

        return new DialerView();
    }
}
