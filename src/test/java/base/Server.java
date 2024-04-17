package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.time.Duration;

public class Server {

    private AppiumDriverLocalService service;

    // Appium Service Builder
    private void buildAppiumService(){

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home") +
                        "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(30))
                .build();
    }

    // Appium Service Builder Call
    private AppiumDriverLocalService getAppiumService(){

        if (service == null){

            System.out.println("[i] Building Appium Service...");
            buildAppiumService();
        }

        return service;
    }

    // Starting Appium Server
    protected void initServer(){

        System.out.println("[i] Starting Appium Service...");
        getAppiumService().start();
        System.out.println(service.getUrl());
        System.out.println("[i] Server Active Status: " + service.isRunning());
    }

    // Stopping Appium Server
    protected void stopServer(){
        if (service != null){

            System.out.println("[i] Stopping Appium Service...");
            getAppiumService().stop();

            // Closing the stream and releasing any system resources associated with it.
            getAppiumService().close();
        }
    }

}
