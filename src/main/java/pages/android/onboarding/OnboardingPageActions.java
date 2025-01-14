package pages.android.onboarding;

import static com.codeborne.selenide.DragAndDropOptions.to;

public class OnboardingPageActions {
    public static void slideToAgree() {
        OnboardingPageSelectors.sliderButton.dragAndDrop(to(OnboardingPageSelectors.sliderArrow));
    }
}
