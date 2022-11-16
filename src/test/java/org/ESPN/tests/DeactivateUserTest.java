package org.ESPN.tests;

import org.testng.annotations.Test;

public class DeactivateUserTest extends BaseTest {

    private final String EMAIL = "utyd_qarri3@kygur.com";
    private final String PASSWORD = "hGWKrb7*ZU2Y,_.";

    @Test
    public void deactivateUserTest() {
        home.switchToBanner();
        home.closeBanner();
        home.switchToHome();
        home.openLoginModal();
        home.switchToModal();
        home.fillUsernameEmailInput(EMAIL);
        home.fillPasswordInput(PASSWORD);
        home.submitLoginForm();
        home.switchToHome();
        home.modalIsClosed();
        home.mouseOverUserIcon();
        home.clickESPNProfile();
        home.switchToModal();
        home.loadingSpinnerIsOver();
        home.clickDeleteAccount();
        home.clickDeleteAccountConfirmation();
        home.switchToHome();


    }
}
