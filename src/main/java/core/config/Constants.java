package core.config;

import core.helpers.Utils;
import org.testng.xml.XmlSuite;

/**
 * @author Deniz Hamamcioglu - denizhamamcioglu@gmail.com
 * Holds the constant values which are not subject to change that frequently that are used accross the automation suite.
 */
public class Constants {
    public static final int TIMEOUT = 45000;
    public static final int LOAD_TIMEOUT = 30000;
    public static final int TYPE_DELAY = 100;
    public static final int POLL_INTERVAL = 200;
    public static final int TEST_RETRY_COUNT = 1;
    public static final int API_RETRY_COUNT = 1;
    public static final int DEFAULT_PARALLEL_THREAD_COUNT = 5;
    public static final XmlSuite.ParallelMode PARALLEL_MODE = XmlSuite.ParallelMode.TESTS;
    public static final int MAX_TRY_COUNT_API = 150; // equals to 30 seconds of retry time with the given 200 poll interval.
    public static final int MAX_TRY_COUNT_UI = 15; // equals to 3 seconds of retry time with the given 200 poll interval.
    public static final int SCROLL_SPEED = 100;
    public static final String CONFIG_FILE_PATH = "/src/main/resources/";
    public static final String TEST_RESOURCES_PATH = "/src/test/resources/";
    public static final String DOWNLOAD_PATH = Utils.constructPathForFile("/src/test/downloads/");
    public static final String APPIUM_SERVER_ADDRESS = "127.0.0.1";
    public static final int APPIUM_PORT = 4723;
    public static final String APPIUM_FULL_URL = String.format("http://%s:%d/", APPIUM_SERVER_ADDRESS, APPIUM_PORT);
    public static final String PACKAGE_NAME = "com.bragi.app";
    public static final String ACTIVITY_NAME = "com.bragi.earbuds.presentation.main.MainActivity";
}
