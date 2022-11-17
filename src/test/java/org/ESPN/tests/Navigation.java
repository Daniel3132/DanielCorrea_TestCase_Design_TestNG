package org.ESPN.tests;

public class Navigation extends BaseTest {

   public Navigation() {
   }

   public void fastLogin() {
        home.switchToBanner();
        home.closeBanner();
        home.switchToHome();
        home.openLoginModal();
        home.switchToModal();
        home.fillUsernameEmailInput(EMAIL);
        home.fillPasswordInput(PASSWORD);
        home.submitLoginForm();
        home.switchToHome();
    }
}
