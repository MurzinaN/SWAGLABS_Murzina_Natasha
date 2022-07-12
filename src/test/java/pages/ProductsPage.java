package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends HomePage{
    String productContainerLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private By addToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private By productLink = By.cssSelector("a[id$='_link']");
    private By productsPageHeader = By.id("header_container");
    private By productPrice = By.className("inventory_item_price");
    private By descriptionText = By.className("inventory_item_desc");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isProductsPageHeaderDisplayed(){
        return driver.findElement(productsPageHeader).isDisplayed();
    }
    public void openItemByName(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(productLink).click();
    }
    public void clickAddToCartButton(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(addToCartButton).click();
    }
    public String getProductPrice(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(productPrice).getText();
    }
    public String getProductDescriptionText(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(descriptionText).getText();
    }
    private WebElement getProductContainerByName(String productName){
        return driver.findElement(By.xpath(String.format(productContainerLocator, productName)));
    }
}
