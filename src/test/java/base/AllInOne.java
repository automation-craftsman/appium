package base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class AllInOne {

    public static AppiumDriver driver;
    private static final By dialer = AppiumBy.accessibilityId("key pad");

    private static final By digitField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.android.dialer:id/digits\"]");
//    private static final By digitOne = AppiumBy.accessibilityId("1,");
//    private static final By digitTwo = AppiumBy.accessibilityId("2,ABC");
//    private static final By digitThree = AppiumBy.accessibilityId("3,DEF");
    private static final By dialButton = AppiumBy.accessibilityId("dial");
    private static final By endCallButton = AppiumBy.accessibilityId("End call");


    public static void main(String[] args) throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("pixel");
        options.setAppPackage("com.android.dialer");
        options.setAppActivity("com.android.dialer.main.impl.MainActivity");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(dialer).click();
        driver.findElement(digitField).sendKeys("123");

//        driver.findElement(digitOne).click();
//        driver.findElement(digitTwo).click();
//        driver.findElement(digitThree).click();

        driver.findElement(dialButton).click();
        driver.findElement(endCallButton).click();


        driver.quit();

    }
}
