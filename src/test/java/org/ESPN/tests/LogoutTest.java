package org.ESPN.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LogoutTest extends BaseTest{
    private final String EMAIL = "utyd_qarri83@kygur.com";
    private final String PASSWORD = "hGWKrb7*ZU2Y,_.";

    @Test
    public void logout() {
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
        home.clickLogoutBtn();
        home.userOptionsListMenuIsClosed();
        home.mouseOverUserIcon();
        checkThat("Welcome text is correct", home.welcomeTextValue(), is("Welcome!"));
    }
}
