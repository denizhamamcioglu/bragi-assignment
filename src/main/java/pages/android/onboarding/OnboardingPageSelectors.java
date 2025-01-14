package pages.android.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

//import static com.codeborne.selenide.appium.AppiumSelectors.byText;

public class OnboardingPageSelectors {
    // Divs
    public static SelenideElement sliderButton = $(id("com.bragi.app:id/thumb"));
    public static SelenideElement sliderArrow = $(id("com.bragi.app:id/arrow"));
    public static SelenideElement pageTitle = $(id("com.bragi.app:id/tv_title"));
    public static SelenideElement pageInfoText = $(id("com.bragi.app:id/tv_info"));
    public static SelenideElement searchingAnimation = $(id("com.bragi.app:id/iv_lottie_loader"));
}
