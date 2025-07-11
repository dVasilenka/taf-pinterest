package com.pinterest.UI;

import org.junit.Assert;
import org.junit.Test;

public class PinterestTest extends BaseTest {
    String emailIsNotFilledAlert = null;
    @Test
    public void loginTest() {
        loginPage.clickOnFieldAndEnterEmail("");
        loginPage.clickOnFieldAndEnterPassword("Qazxc1478!");
        loginPage.clickOnEnterButton();
        emailIsNotFilledAlert = loginPage.getTextEmailIsNotFilledAlert();
        Assert.assertTrue("Alert is not displayed", loginPage.emailIsNotFilledAlertIsDisplayed());
    }

    @Test
    public void loginWithoutPasswordTest() {
        loginPage.clickOnFieldAndEnterEmail("test.test@testcom");
        loginPage.clickOnFieldAndEnterPassword("");
        loginPage.clickOnEnterButton();
        Assert.assertTrue("Alert is not displayed", loginPage.wrongEmailAlertIsDisplayed());
        String wrongEmailAlert = loginPage.getWrongEmailAlert();
        Assert.assertNotEquals("Alerts are equals", emailIsNotFilledAlert, wrongEmailAlert);
    }
    @Test
    public void loginWithInvalidPasswordTest() {
        loginPage.clickOnFieldAndEnterEmail("test.test@test.com");
        loginPage.clickOnFieldAndEnterPassword("Q1235");
        loginPage.clickOnEnterButton();
        Assert.assertTrue("Alert is not displayed", loginPage.invalidPasswordAlertIsDisplayed());
    }
}