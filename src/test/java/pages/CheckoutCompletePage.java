package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends HomePage {

    private final By orderCompletionMessage = By.className("complete-header");
    private final By backHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getOrderCompletionMessageText() {
        return driver.findElement(orderCompletionMessage).getText();
    }

    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }

}
