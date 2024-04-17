package views;

import base.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import support.Utilities;

public class DialerView extends Base {

    private final By numberField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.android.dialer:id/digits\"]");
    private final By dialButton = AppiumBy.accessibilityId("dial");

//    Utilities utilities = new Utilities();

    public void inputNumbers(String numbers){

//        utilities.getElement(numberField).sendKeys(numbers);

        driver.findElement(numberField).sendKeys("12345");
    }

    public CallView call(){

//        utilities.getElement(dialButton).click();

        driver.findElement(dialButton).click();

        return new CallView();
    }
}
