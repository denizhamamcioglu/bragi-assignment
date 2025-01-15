package core.base;

import com.codeborne.selenide.WebDriverProvider;
import core.config.Constants;
import core.helpers.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.openqa.selenium.Capabilities;
import org.slf4j.helpers.CheckReturnValue;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class that is responsible for driver related operations.
 */
@NullMarked
public class DriverManager implements WebDriverProvider {
    /**
     * Creates a new Appium driver in order to interact with the desired mobile device/emulator.
     * @param capabilities - Capabilities object that will be used to create the driver instance.
     * @return AndroidDriver instance.
     */
    @Override
    @CheckReturnValue
    @NonNull
    public AppiumDriver createDriver(Capabilities capabilities) {
        URL appiumUrl = appiumUrl();
        return new AndroidDriver(appiumUrl, getAndroidCapabilities());
    }

    /**
     * Returns the designated Android capabilities.
     *
     * @return Capabilities - options based object of Android device capabilities.
     */
    public static Capabilities getAndroidCapabilities() { // TODO: These values can be fetched from JSON files combined with command line parameters for easier device switching.
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("emulator-5554");
        options.setPlatformVersion("14");
        options.setApp(Utils.constructPathForFile(Constants.TEST_RESOURCES_PATH + "app-bragi.apk"));
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAutoGrantPermissions(true);
        options.setDeviceName("Pixel 8 Pro Emulator");

        return options;
    }

    private static Capabilities getIosCapabilities() { // TODO: this can be populated with iOS capabilities in the future.
        return null;
    }

    /**
     * Returns the URL object of the Appium server.
     * @return URL object of the Appium server.
     */
    private static URL appiumUrl() {
        try {
            return new URL(Constants.APPIUM_FULL_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
