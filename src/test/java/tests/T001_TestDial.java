package tests;

import base.Base;
import org.testng.annotations.Test;
import views.CallView;
import views.DialerView;
import views.MainView;

public class T001_TestDial extends Base {

    MainView mainView;

    @Test
    public void makeCall(){

        // Opening the dialer
        DialerView dialerView = mainView.openDialer();

        // Sending numbers to the number field
        dialerView.inputNumbers("123");

        // Calling the number
        CallView callView = dialerView.call();

        // Ending the call
        mainView = callView.endCall();
    }
}
