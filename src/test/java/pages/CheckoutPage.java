package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Screen;

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
    @Step("Set firstName: {firstName}")
    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    @Step("Set lastName: {lastName}")
    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    @Step("Set zip: {zip}")
    public void setZip(String zip) {
        driver.findElement(zipInput).sendKeys(zip);
    }
    @Step("Click button 'Continue'")
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
    @Step("Ñhecking the presence of error message on display")
    public boolean isCheckoutErrorMessageDisplayed() {
        Screen.attachScreenshot(driver);
        return driver.findElement(checkoutErrorMassage).isDisplayed();
    }
    @Step("Get text error message")
    public String getCheckoutErrorMessageText() {
        return driver.findElement(checkoutErrorMassage).getText();
    }

    public boolean checkoutFormPresent() {
        return !driver.findElements(checkoutForm).isEmpty();
    }
}
