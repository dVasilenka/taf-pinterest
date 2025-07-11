package elements;

import org.openqa.selenium.By;

public class Alerts extends BaseElements {
    public Alerts(By locator) {
        super(locator);
    }

    public boolean alertIsDisplayed() {
        return elementIsDisplayed();
    }
    public String alertIsNotDisplayed() {
        return getElementText();
    }
}
