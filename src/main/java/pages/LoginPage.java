package pages;

import elements.Alerts;
import elements.Button;
import elements.EmailField;
import elements.PasswordField;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class LoginPage {
    EmailField emailField = new EmailField(By.xpath("//input[@data-test-id='emailInputField']"));
    PasswordField passwordField = new PasswordField(By.xpath("//input[@data-test-id='passwordInputField']"));
    Button enterButton = new Button(By.xpath("//button[@type='submit']"));
    Alerts emailIsNotFilledAlert = new Alerts(By.xpath("//div[@role='alert']"));
    Alerts wrongEmailAlert = new Alerts(By.xpath("//span[@id='email-error']"));
    Alerts invalidPasswordAlert = new Alerts(By.xpath("//span[@id='password-error']"));

    public void clickOnFieldAndEnterEmail(String email) {
        WaitUtils.waitForElements(condition -> emailField.fieldIsDisplayed());
        emailField.enterEmail(email);
    }

    public void clickOnFieldAndEnterPassword(String password) {
        passwordField.enterPassword(password);
    }

    public void clickOnEnterButton() {
        enterButton.clickOnButton();
    }

    public boolean emailIsNotFilledAlertIsDisplayed() {
        WaitUtils.waitForElements(condition -> emailIsNotFilledAlert.alertIsDisplayed());
        return emailIsNotFilledAlert.alertIsDisplayed();
    }

    public boolean wrongEmailAlertIsDisplayed() {
        WaitUtils.waitForElements(condition -> wrongEmailAlert.alertIsDisplayed());
        return wrongEmailAlert.alertIsDisplayed();
    }

    public String getTextEmailIsNotFilledAlert() {
        return emailIsNotFilledAlert.getElementText();
    }

    public String getWrongEmailAlert() {
        return emailIsNotFilledAlert.getElementText();
    }

    public boolean invalidPasswordAlertIsDisplayed() {
        WaitUtils.waitForElements(condition -> invalidPasswordAlert.alertIsDisplayed());
        return invalidPasswordAlert.alertIsDisplayed();
    }
}
