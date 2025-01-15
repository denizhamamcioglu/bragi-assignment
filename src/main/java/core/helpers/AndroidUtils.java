package core.helpers;

import com.codeborne.selenide.appium.SelenideAppium;
import core.config.Constants;
import data.Enums.AndroidPermissions;

import java.io.IOException;

/**
 * Utility methods specific for Android devices.
 */
public class AndroidUtils {
    /**
     * Toggles the bluetooth (on or off) by using ADB commands on Android devices.
     * @param enable - Bluetooth will be enabled if set to true.
     * @param deviceId - Target device UDID.
     * @return String output of the executed command.
     * @throws IOException
     * @throws InterruptedException
     */
    public static String toggleBluetooth(boolean enable, String deviceId) throws IOException, InterruptedException {
        if (enable) {
            return CommandLineUtils.executeCommand(String.format("adb -s %s shell svc bluetooth enable", deviceId));
        } else {
            return CommandLineUtils.executeCommand(String.format("adb -s %s shell svc bluetooth disable", deviceId));
        }
    }

    /**
     * Toggles the Wi-Fi (on or off) by using ADB commands on Android devices.
     * @param enable - Wi-Fi will be enabled if set to true.
     * @param deviceId - Target device UDID.
     * @return String output of the executed command.
     * @throws IOException
     * @throws InterruptedException
     */
    public static String toggleWifi(boolean enable, String deviceId) throws IOException, InterruptedException {
        if (enable) {
            return CommandLineUtils.executeCommand(String.format("adb -s %s shell svc wifi enable", deviceId));
        } else {
            return CommandLineUtils.executeCommand(String.format("adb -s %s shell svc wifi disable", deviceId));
        }
    }

    /**
     * Revokes the given permissions using ADB commands.
     * @param permission - Permission to be revoked. Check out AndroidPermissions enum for further details.
     * @throws IOException
     * @throws InterruptedException
     */
    public static void revokePermission(AndroidPermissions permission) throws IOException, InterruptedException {
        CommandLineUtils.executeCommand(String.format("adb shell pm revoke %s %s", Constants.PACKAGE_NAME, permission.getValue()));
    }

    /**
     * Restarts the app.
     */
    public static void restartApp() {
        SelenideAppium.terminateApp(Constants.PACKAGE_NAME);
        SelenideAppium.launchApp();
    }
}
