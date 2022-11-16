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
        home.switchToModal();
        super.scrollToBottom();
        home.clickDeleteAccount();
        home.clickDeleteAccountConfirmation();
        home.switchToHome();
        home.openLoginModal();
        home.switchToModal();
        home.fillUsernameEmailInput(this.EMAIL);
        home.fillPasswordInput(this.PASSWORD);
        home.submitLoginForm();
        checkThat("Failed text is valid", home.failedLoginAttempt(), is("Account Deactivated"));
    }
}
