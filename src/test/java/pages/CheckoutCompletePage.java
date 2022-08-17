package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Screen;

public class CheckoutCompletePage extends HomePage {

    private final By orderCompletionMessage = By.className("complete-header");
    private final By backHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    @Step("Get message text jn Checkout:Complete page")
    public String getOrderCompletionMessageText() {
        Screen.attachScreenshot(driver);
        return driver.findElement(orderCompletionMessage).getText();
    }

    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }

}
