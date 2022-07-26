package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends HomePage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");
    private final By checkoutErrorMassage = By.cssSelector(".error-message-container.error");
    private final By checkoutForm = By.xpath("//form/div[@class='checkout_info']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setZip(String zip) {
        driver.findElement(zipInput).sendKeys(zip);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public boolean isCheckoutErrorMessageDisplayed() {
        return driver.findElement(checkoutErrorMassage).isDisplayed();
    }

    public String getCheckoutErrorMessageText() {
        return driver.findElement(checkoutErrorMassage).getText();
    }

    public boolean checkoutFormPresent() {
        return !driver.findElements(checkoutForm).isEmpty();
    }
}
