package com.pinterest.UI;

import org.junit.jupiter.api.*;


class LoginTest extends BaseTest {
    private static String emailIsNotFilledAlert = null;

    @Test
    void loginWithEmptyEmailTest() {
        loginPage.clickOnFieldAndEnterEmail(EMPTY_EMAIL);
        loginPage.clickOnFieldAndEnterPassword(VALID_PASSWORD);
        loginPage.clickOnEnterButton();
        emailIsNotFilledAlert = loginPage.getTextEmailIsNotFilledAlert();
        Assertions.assertTrue(loginPage.emailIsNotFilledAlertIsDisplayed(), "Alert is not displayed");
    }

    @Test
    void loginWithoutPasswordTest() {
        loginPage.clickOnFieldAndEnterEmail(VALID_EMAIL);
        loginPage.clickOnFieldAndEnterPassword(EMPTY_PASSWORD);
        loginPage.clickOnEnterButton();
        Assertions.assertTrue(loginPage.wrongEmailAlertIsDisplayed(), "Alert is not displayed");
        String wrongEmailAlert = loginPage.getWrongEmailAlert();
        Assertions.assertNotEquals(emailIsNotFilledAlert, wrongEmailAlert, "Alerts are equals");
    }

    @Test
    void loginWithInvalidPasswordTest() {
        loginPage.clickOnFieldAndEnterEmail(VALID_EMAIL);
        loginPage.clickOnFieldAndEnterPassword(INVALID_PASSWORD);
        loginPage.clickOnEnterButton();
        Assertions.assertTrue(loginPage.invalidPasswordAlertIsDisplayed(), "Alert is not displayed");
    }

    @Test
    void loginWithInvalidEmailTest() {
        loginPage.clickOnFieldAndEnterEmail(INVALID_EMAIL);
        loginPage.clickOnFieldAndEnterPassword(VALID_PASSWORD);
        loginPage.clickOnEnterButton();
        emailIsNotFilledAlert = loginPage.getTextEmailIsNotFilledAlert();
        Assertions.assertTrue(loginPage.checkInvalidEmailAlert(), "Alert is not displayed");
        System.out.println(loginPage.getColorValue());
        Assertions.assertEquals("rgba(138, 15, 15, 1)",loginPage.getColorValue());
    }
}
