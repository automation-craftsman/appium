package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Emulator {

    // Checking the state of the emulator
    protected boolean isEmulatorRunning () throws IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec("adb devices");
        process.waitFor();

        boolean state = false;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String output;

        while ((output = bufferedReader.readLine()) != null) {

            if (output.contains("emulator")){

                state = true;
            }
        }

        bufferedReader.close();

        return state;
    }
}
