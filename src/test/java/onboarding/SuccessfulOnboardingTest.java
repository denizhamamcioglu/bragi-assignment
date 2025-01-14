package onboarding;

import com.codeborne.selenide.Configuration;
import core.config.Constants;
import core.helpers.AndroidUtils;
import core.helpers.Utils;
import data.Enums.AndroidPermissions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.onboarding.OnboardingPageActions;
import pages.android.onboarding.OnboardingPageSelectors;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;

public class SuccessfulOnboardingTest {
    @BeforeClass
    @Description("Setup test environment.")
    public void testSetup() throws IOException, InterruptedException {

    }

    @Test()
    @Description("Successful onboarding test.")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulOnboarding() throws InterruptedException {
        OnboardingPageSelectors.pageTitle.shouldBe(visible).shouldHave(text("Welcome"));
        OnboardingPageActions.slideToAgree();

        OnboardingPageSelectors.pageInfoText.shouldBe(visible).shouldHave(text("Looking for a device"));
        OnboardingPageSelectors.pageTitle.shouldBe(visible).shouldHave(text("No Headphones Found"));
    }
}
