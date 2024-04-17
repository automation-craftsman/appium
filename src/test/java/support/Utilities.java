package support;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utilities extends Base {

    public WebElement getElement(By locator){

        return driver.findElement(locator);
    }
}
