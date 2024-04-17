package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class Base {

    public static AppiumDriver driver;

    static Server server = new Server();
    static Emulator emulator = new Emulator();

    @BeforeSuite
    public static void setup() throws URISyntaxException, IOException, InterruptedException {

        // Initiating Appium Server
        server.initServer();

        UiAutomator2Options options = new UiAutomator2Options();

        // Launching Android Emulator
        if (!emulator.isEmulatorRunning()) {

            System.out.println("[i] Starting Android Emulator...");
            options.setAvd("pixel");
            options.setAvdLaunchTimeout(Duration.ofSeconds(120));
        }

        // Desired Capabilities
        options.setDeviceName("emulator-5554");
//        options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\android.wdio.native.app.v1.0.8.apk");
        options.setAppPackage("com.android.dialer");
        options.setAppActivity("com.android.dialer.main.impl.MainActivity");

        // Launching Appium Driver
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println("Session ID - Setup: " + driver.getSessionId());
    }

    @AfterSuite
    public static void cleanUp(){
        // Quiting Appium Driver
        driver.quit();
        // Stopping Appium Server
        server.stopServer();
    }
}
