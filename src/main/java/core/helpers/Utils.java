package core.helpers;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.base.DriverManager;
import core.config.Constants;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.selenide.AllureSelenide;

import java.io.File;
import java.io.IOException;

/**
 * General utilities class.
 */
public class Utils {
    /**
     * Constructs a full path dynamic to the current working directory for the given file path.
     *
     * @param filePath - File path to concatenated to the current working directory.
     * @return String - Full file path.
     */
    public static String constructPathForFile(String filePath) {
        String basePath = new File("").getAbsolutePath();
        return basePath.concat(filePath);
    }

    /**
     * Registers the Allure reporter to Selenide.
     */
    public static void addAllureReporter() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
                        .includeSelenideSteps(true));
    }

    /**
     * Configures Selenide.
     */
    public static void configureSelenide() {
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.timeout = Constants.TIMEOUT;
        Configuration.pageLoadTimeout = Constants.LOAD_TIMEOUT;
        Configuration.screenshots = true;
        Configuration.browser = DriverManager.class.getName();
    }

    /**
     * Starts the Appium server programmatically and returns the Appium service instance for future reference.
     * @return Started AppiumDriverLocalService instance for future reference.
     */
    public static AppiumDriverLocalService startAppiumServer() {
        AppiumServiceBuilder appiumBuilder = new AppiumServiceBuilder();
        AppiumDriverLocalService appiumService = appiumBuilder
                .withIPAddress(Constants.APPIUM_SERVER_ADDRESS)
                .usingPort(Constants.APPIUM_PORT)
                .build();

        appiumService.start();
        return appiumService;
    }

    /**
     * Stops the given Appium server.
     * @param appiumService - Appium server instance to be stopped.
     */
    public static void stopAppiumServer(AppiumDriverLocalService appiumService) {
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
        }
    }

    /**
     * Executes the steps of test session prerequisites.
     * @return AppiumDriverLocalService instance for future reference.
     */
    public static AppiumDriverLocalService setupTestEnvironment() throws IOException, InterruptedException {
        AppiumDriverLocalService appiumService = startAppiumServer();
        configureSelenide();
        String testDeviceUdid = DriverManager.getAndroidCapabilities().getCapability("udid").toString();
        AndroidUtils.toggleBluetooth(true, testDeviceUdid);
        AndroidUtils.toggleWifi(true, testDeviceUdid);
        SelenideAppium.launchApp();
        return appiumService;
    }
}
