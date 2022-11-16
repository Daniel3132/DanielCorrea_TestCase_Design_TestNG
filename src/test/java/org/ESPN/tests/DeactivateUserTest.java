package org.ESPN.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class DeactivateUserTest extends BaseTest {

    @Test
    public void deactivateUserTest() throws InterruptedException {
        fastLogin();
        home.modalIsClosed();

        home.mouseOverUserIcon();
        home.isOpenUserOptionsList();
        home.clickESPNProfile();
        home.waitForSpinner();
        home.switchToUpdateAccountModal();
        home.clickDeleteAccount();
        home.clickDeleteAccountConfirmation();
        home.switchToHome();
        fastLogin();
        home.userOptionsListMenuIsClosed();
        home.mouseOverUserIcon();
        checkThat("Welcome text is correct", home.welcomeTextValue(), is("Welcome!"));
    }
}
