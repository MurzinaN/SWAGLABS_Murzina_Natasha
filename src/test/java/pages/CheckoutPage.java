package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends HomePage{

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By zipInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By checkoutErrorMassage = By.cssSelector(".error-message-container.error");
    private By checkoutForm = By.xpath("//form/div[@class='checkout_info']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void setZip(String zip){
        driver.findElement(zipInput).sendKeys(zip);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }
    public boolean isCheckoutErrorMessageDisplayed(){
        return driver.findElement(checkoutErrorMassage).isDisplayed();
    }
    public String getCheckoutErrorMessageText(){
        return driver.findElement(checkoutErrorMassage).getText();
    }
    public boolean checkoutFormPresent(){
        return driver.findElements(checkoutForm).isEmpty();
    }
}
