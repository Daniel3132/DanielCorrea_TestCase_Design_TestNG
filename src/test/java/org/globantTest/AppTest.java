package org.globantTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class AppTest {
    public Logger log = Logger.getLogger(this.getClass().getName());

    public void goToWebSite(){
        log.info("Go to https://www.espnqa.com/?_adbock=true&src=com&espn=cloud");
    }

    @BeforeSuite
    public void createAccount(){
        goToWebSite();
        log.info("\nClick on Sing up");
        log.info("Fill First Name Field");
        log.info("Fill Last Name Field");
        log.info("Fill Email Address  Field");
        log.info("Fill Password Field");
        log.info("Click on Sing up Form Button\n");
    }

    @BeforeTest
    public void openBrowser() {
        log.info("Open the Browser\n");
    }

    @AfterTest
    public void closeBrowser() {
        log.info("Close the Browser\n");
    }
}