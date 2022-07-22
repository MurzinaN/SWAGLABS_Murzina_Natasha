package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends HomePage {
    String productContainerLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    @FindBy(className = "product_sort_container")
    WebElement sortButton;
    private final By addToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private final By productLink = By.cssSelector("a[id$='_link']");
    private final By productsPageHeader = By.id("header_container");
    private final By productPrice = By.className("inventory_item_price");
    private final By descriptionText = By.className("inventory_item_desc");


    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    public void openItemByName(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(productLink).click();
    }

    public void clickAddToCartButton(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(addToCartButton).click();
    }

    public String getProductPrice(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(productPrice).getText();
    }

    public String getProductDescriptionText(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(descriptionText).getText();
    }

    private WebElement getProductContainerByName(String productName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productName)));
    }

    public void clickSortNameAToZ() {
        Select select = new Select(sortButton);
        List<WebElement> options = select.getOptions();
        options.get(0).click();
    }

    public void clickSortNameZToA() {
        Select select = new Select(sortButton);
        List<WebElement> options = select.getOptions();
        options.get(1).click();
    }

    public void clickSortPriceLowToHigh() {
        Select select = new Select(sortButton);
        List<WebElement> options = select.getOptions();
        options.get(2).click();
    }

    public void clickSortPriceHighToLow() {
        Select select = new Select(sortButton);
        List<WebElement> options = select.getOptions();
        options.get(3).click();
    }

    public List<String> sortNameZToA() {
        List<WebElement> productsName = driver.findElements(By.className("inventory_item_name"));
        List<String> names = productsName.stream().map(option -> option.getText()).toList();
        return names;
    }

    public List<String> expectedProductNamesSortNameZToA() {
        List<String> expectedProductName = new ArrayList<String>();
        expectedProductName.add("Sauce Labs Bike Light");
        expectedProductName.add("Sauce Labs Fleece Jacket");
        expectedProductName.add("Sauce Labs Bolt T-Shirt");
        expectedProductName.add("Sauce Labs Backpack");
        expectedProductName.add("Test.allTheThings() T-Shirt (Red)");
        expectedProductName.add("Sauce Labs Onesie");
        Collections.sort(expectedProductName);
        Collections.reverse(expectedProductName);
        return expectedProductName;
    }


}
