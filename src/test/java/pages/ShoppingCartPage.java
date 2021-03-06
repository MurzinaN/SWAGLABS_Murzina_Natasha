package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends HomePage {
    String productShoppingCartLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='cart_item']";
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private final By productShoppingCartPrice = By.className("inventory_item_price");
    private final By descriptionShoppingCartText = By.className("inventory_item_desc");
    private final By quantityShoppingCartText = By.className("cart_quantity");
    private final By removeButton = By.cssSelector("button[id^='remove-']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    private WebElement getProductShoppingCartByName(String productName) {
        return driver.findElement(By.xpath(String.format(productShoppingCartLocator, productName)));
    }

    public String getProductShoppingCartPrice(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(productShoppingCartPrice).getText();
    }

    public String getProductDescriptionShoppingCartText(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(descriptionShoppingCartText).getText();
    }

    public String getQuantityProductShoppingCartText(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(quantityShoppingCartText).getText();
    }

    public void clickRemoveButton(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        productShoppingCartContainer.findElement(removeButton).click();
    }

    public boolean productContainerShoppingCartPresent(String productName) {
        return !driver.findElements(By.xpath(String.format(productShoppingCartLocator, productName))).isEmpty();
    }
}
