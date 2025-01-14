package core.listeners;

import core.helpers.Utils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.IOException;

public class SuiteListener implements ISuiteListener {
    AppiumDriverLocalService appiumService;

    @Override
    public void onStart(ISuite suite) {
        try {
            appiumService = Utils.setupTestEnvironment();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        Utils.stopAppiumServer(appiumService);
    }
}
