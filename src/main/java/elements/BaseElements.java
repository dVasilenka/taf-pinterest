package elements;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElements {
    private final By locator;

    public BaseElements(By locator) {
        this.locator = locator;
    }

    public WebElement getElement() {
        return Browser.getDriver().findElement(locator);
    }

    public void clickOnElement() {
        getElement().click();
    }

    public boolean elementIsDisplayed() {
        return getElement().isDisplayed();
    }

    public void enterValue(String value) {
        getElement().sendKeys(value);
    }

    public String getElementText() {
        return getElement().getText();
    }

    public String getCssValue(String attribute) {
        return getElement().getCssValue(attribute);
    }
}
