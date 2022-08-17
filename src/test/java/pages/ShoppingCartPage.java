package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Screen;

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
    @Step("Click button 'Checkout'")
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
    @Step("Chose product with name {productName} in shopping cart")
    private WebElement getProductShoppingCartByName(String productName) {
        return driver.findElement(By.xpath(String.format(productShoppingCartLocator, productName)));
    }
    @Step("Get product price in ShoppingCart")
    public String getProductShoppingCartPrice(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(productShoppingCartPrice).getText();
    }
    @Step("Get product description in ShoppingCart")
    public String getProductDescriptionShoppingCartText(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(descriptionShoppingCartText).getText();
    }
    @Step("Get product quantity in ShoppingCart")
    public String getQuantityProductShoppingCartText(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(quantityShoppingCartText).getText();
    }
    @Step("Click button 'Remove'")
    public void clickRemoveButton(String productName) {
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        productShoppingCartContainer.findElement(removeButton).click();
        Screen.attachScreenshot(driver);
    }
    @Step("Ñhecking the presence of a product with the name: {productName} in ShoppingCart")
    public boolean productContainerShoppingCartPresent(String productName) {
        Screen.attachScreenshot(driver);
        return !driver.findElements(By.xpath(String.format(productShoppingCartLocator, productName))).isEmpty();
    }
}
