package org.ESPN.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LogoutTest extends BaseTest{
    @Test
    public void logout() {
        fastLogin();
        home.modalIsClosed();
        home.mouseOverUserIcon();
        home.clickLogoutBtn();
        home.userOptionsListMenuIsClosed();
        home.mouseOverUserIcon();
        checkThat("Welcome text is correct", home.welcomeTextValue(), is("Welcome!"));
    }
}
