package com.pinterest.UI;

import browser.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class BaseTest {
    protected final static String EMPTY_EMAIL = "";
    protected final static String VALID_PASSWORD = "Qazxc1478!";
    protected final static String VALID_EMAIL = "test.test@testcom";
    protected final static String EMPTY_PASSWORD = "";
    protected final static String INVALID_PASSWORD = "Q1235";
    protected final static String INVALID_EMAIL = "1";
    protected final static LoginPage loginPage = new LoginPage();
    protected final static String BASE_URL = "https://www.pinterest.com/#login";

    @BeforeEach
    public void runBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Browser.getDriver().get(BASE_URL);
        Browser.getDriver().manage().window().fullscreen();
    }

    @AfterEach
    public void tearDown() {
        Browser.quit();
    }
}
