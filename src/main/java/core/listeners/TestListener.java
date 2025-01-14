package core.listeners;

import com.codeborne.selenide.Configuration;
import core.helpers.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onTestStart(ITestResult result) {
        Utils.addAllureReporter();
        log.info("Starting {} tests using {} browser.", result.getName(), Configuration.browser);
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }
}
