package com.pinterest.UI;

import org.junit.jupiter.api.*;


class PinterestTest extends BaseTest {
     private static String emailIsNotFilledAlert = null;

    @Test
    void loginWithEmptyEmailTest() {
        loginPage.clickOnFieldAndEnterEmail("");
        loginPage.clickOnFieldAndEnterPassword("Qazxc1478!");
        loginPage.clickOnEnterButton();
        emailIsNotFilledAlert = loginPage.getTextEmailIsNotFilledAlert();
        Assertions.assertTrue(loginPage.emailIsNotFilledAlertIsDisplayed(), "Alert is not displayed");
    }

    @Test
    void loginWithoutPasswordTest() {
        loginPage.clickOnFieldAndEnterEmail("test.test@testcom");
        loginPage.clickOnFieldAndEnterPassword("");
        loginPage.clickOnEnterButton();
        Assertions.assertTrue(loginPage.wrongEmailAlertIsDisplayed(), "Alert is not displayed");
        String wrongEmailAlert = loginPage.getWrongEmailAlert();
        Assertions.assertNotEquals(emailIsNotFilledAlert, wrongEmailAlert, "Alerts are equals");
    }

    @Test
    void loginWithInvalidPasswordTest() {
        loginPage.clickOnFieldAndEnterEmail("test.test@test.com");
        loginPage.clickOnFieldAndEnterPassword("Q1235");
        loginPage.clickOnEnterButton();
        Assertions.assertTrue(loginPage.invalidPasswordAlertIsDisplayed(), "Alert is not displayed");
    }

    @Test
    void loginWithInvalidEmailTest() {
        loginPage.clickOnFieldAndEnterEmail("1");
        loginPage.clickOnFieldAndEnterPassword("Qazxc1478!");
        loginPage.clickOnEnterButton();
        emailIsNotFilledAlert = loginPage.getTextEmailIsNotFilledAlert();
        Assertions.assertTrue(loginPage.checkInvalidEmailAlert(), "Alert is not displayed");
        System.out.println(loginPage.getColorValue());
        Assertions.assertEquals("rgba(138, 15, 15, 1)",loginPage.getColorValue());
    }
}