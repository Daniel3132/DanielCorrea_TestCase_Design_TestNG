package org.globantTest;

import org.testng.annotations.Test;

public class DeactivateUserTest extends AppTest {

    @Test
    void DeactivateUser() {
        log.info("\nClick on profile");
        log.info("Click on Delete Account");
        log.info("Click on Yes, delete this account");
        log.info("Click on OK");
        goToWebSite();
        log.info("Click on profile");
        log.info("Log in");
        log.info("Check user is invalid\n");
    }
}
