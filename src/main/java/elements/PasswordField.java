package elements;

import org.openqa.selenium.By;

public class PasswordField extends BaseElements {
    public PasswordField(By locator) {
        super(locator);
    }

    public void enterPassword(String password) {
        clickOnElement();
        enterValue(password);
    }
}
