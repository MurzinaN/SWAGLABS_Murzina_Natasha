package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends HomePage {

    private final By addToCartButton = By.cssSelector("button[id^=add-to-cart]");
    private final By backToProductsButton = By.id("back-to-products");
    private final By itemName = By.cssSelector(".inventory_details_name");
    private final By itemDescription = By.cssSelector(".inventory_details_desc.large_size");
    private final By itemPrice = By.cssSelector(".inventory_details_price");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click button 'Add to card'")
    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickBackToProductsButton() {
        driver.findElement(backToProductsButton).click();
    }
    @Step("Get product name")
    public String getItemName() {
        return driver.findElement(itemName).getText();
    }
    @Step("Get product description")
    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }
    @Step("Get product price")
    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }
}
