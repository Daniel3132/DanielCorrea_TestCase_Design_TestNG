package org.globantTest;

import org.testng.annotations.Test;

public class LogoutTest extends AppTest {

    @Test
    void Logout() {
        goToWebSite();
        log.info("\nClick on profile");
        log.info("Click on Log Out");
        log.info("Check is Log out\n");
    }
}
