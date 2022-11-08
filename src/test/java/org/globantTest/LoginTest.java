package org.globantTest;

import org.testng.annotations.Test;

public class LoginTest extends AppTest {

    @Test
    void Login() {
        log.info("\nClick on Login");
        log.info("Fill Email Address / Username Field");
        log.info("Fill Password Field");
        log.info("Click on log in");
        log.info("Check is logged in\n");
    }
}
