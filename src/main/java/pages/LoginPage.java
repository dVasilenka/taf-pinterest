package pages;

import elements.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class LoginPage {
    private final static EmailField emailField = new EmailField(By.xpath("//input[@data-test-id='emailInputField']"));
    private final static PasswordField passwordField = new PasswordField(By.xpath("//input[@data-test-id='passwordInputField']"));
    private final static Button enterButton = new Button(By.xpath("//button[@type='submit']"));
    private final static Alerts emailIsNotFilledAlert = new Alerts(By.xpath("//div[@role='alert']"));
    private final static Alerts wrongEmailAlert = new Alerts(By.xpath("//span[@id='email-error']"));
    private final static Alerts invalidPasswordAlert = new Alerts(By.xpath("//span[@id='password-error']"));
    private final static Alerts invalidEmailAlert = new Alerts(By.xpath("//span[@id='email-error']"));
    private final static Form loginForm = new Form(By.xpath("//div[@data-test-id='login-modal-default']"));
    private final static String COLOR = "color";


    public void clickOnFieldAndEnterEmail(String email) {
        WaitUtils.waitForElements(condition -> loginForm.formIsDisplayed());
        emailField.enterEmail(email);
    }

    public Logger logger = LogManager.getLogger();


    public void clickOnFieldAndEnterPassword(String password) {
        passwordField.enterPassword(password);
        logger.info("Вызываем такой то метод");
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

    public boolean checkInvalidEmailAlert() {
        WaitUtils.waitForElements(condition -> invalidEmailAlert.alertIsDisplayed());
        return invalidEmailAlert.alertIsDisplayed();
    }

    public String getWrongEmailAlert() {
        return emailIsNotFilledAlert.getElementText();
    }

    public boolean invalidPasswordAlertIsDisplayed() {
        WaitUtils.waitForElements(condition -> invalidPasswordAlert.alertIsDisplayed());
        return invalidPasswordAlert.alertIsDisplayed();
    }

    public String getColorValue(){
        WaitUtils.waitForElements(condition -> emailIsNotFilledAlert.alertIsDisplayed());
        return emailIsNotFilledAlert.getAlertCssValue(COLOR);
    }
}
