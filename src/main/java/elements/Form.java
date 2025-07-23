package elements;

import org.openqa.selenium.By;

public class Form extends BaseElements{

    public Form(By locator) {
        super(locator);
    }
    public boolean formIsDisplayed() {
        return elementIsDisplayed();
    }
}
