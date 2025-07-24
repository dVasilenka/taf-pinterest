package elements;

import org.openqa.selenium.By;

public class EmailField extends BaseElements {
    public EmailField(By locator) {
        super(locator);
    }

    public void enterEmail(String email) {
        clickOnElement();
        enterValue(email);
    }

    public boolean fieldIsDisplayed() {
        return elementIsDisplayed();
    }
}
