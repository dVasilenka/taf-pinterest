package com.pinterest.UI;

import browser.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class BaseTest {
    protected final static String EMAIL_FILLING_ERROR = "Электронная почта не указана";
    protected final static String PASSWORD_FILLING_ERROR = "Пароль не указан";
    protected final static LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void runBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Browser.getDriver().get("https://www.pinterest.com/#login");
        Browser.getDriver().manage().window().fullscreen();
    }

    @AfterEach
    public  void tearDown() {
        Browser.quit();
    }
}