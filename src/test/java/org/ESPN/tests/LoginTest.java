package org.ESPN.tests;

import org.ESPN.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;


public class LoginTest extends BaseTest {

    private final String EMAIL = "utyd_qarri83@kygur.com";
    private final String USERNAME = "Daniel";
    private final String PASSWORD = "hGWKrb7*ZU2Y,_.";
    private final String EXPECTED_WELCOME_TEXT = "Welcome" + USERNAME + "!";

    @Test
    public void loginTest() {
        home.switchToBanner();
        home.closeBanner();
        home.switchToHome();
        home.openLoginModal();
        checkThat("Login modal is displayed", home.loginModalIsDisplayed(), is(true));
        home.switchToModal();
        checkThat("ESPN logo is displayed", home.ESPNLogoIsDisplayed(), is(true));
        checkThat("Login button is displayed", home.loginBtnIsDisplayed(), is(true));
        checkThat("SignUp button is displayed", home.signUpBtnIsDisplayed(), is(true));
        home.fillUsernameEmailInput(EMAIL);
        home.fillPasswordInput(PASSWORD);
        home.submitLoginForm();
        home.switchToHome();
        home.modalIsClosed();
        watchPageValidation();
    }

    public void watchPageValidation() {
        WatchPage watchPage = home.goToWatch();
        checkThat("All cards in the second carousel have a title", watchPage.checkAllCardsTitle(), is(true));
        checkThat("All cards in the second carousel have a description", watchPage.checkAllCardsDescription(), is(true));
        watchPage.clickSecondCard();
        checkThat("Close button is visible", watchPage.closeBtnModalIsDisplayed(), is(true));
        watchPage.closeCardModal();
        watchPage.backHome();
        home.mouseOverUserIcon();
        checkThat("Welcome text is correct", home.welcomeTextValue(), is(EXPECTED_WELCOME_TEXT));
        home.clickLogoutBtn();
        home.modalIsClosed();
        home.mouseOverUserIcon();
        checkThat("Welcome text is correct", home.welcomeTextValue(), is("Welcome!"));
    }
}
