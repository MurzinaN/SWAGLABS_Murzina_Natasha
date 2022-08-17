package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends HomePage {
    String productCheckoutOverviewLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='cart_item']";
    private final By productPriceCheckoutOverview = By.className("inventory_item_price");
    private final By descriptionTextCheckoutOverview = By.className("inventory_item_desc");
    private final By quantityProductCheckoutOverview = By.className("cart_quantity");
    private final By priceItemTotal = By.className("summary_subtotal_label");
    private final By priceTax = By.className("summary_tax_label");
    private final By priceTotal = By.className("summary_total_label");
    private final By cancelOverviewButton = By.id("cancel");
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getProductCheckoutOverviewByName(String productName) {
        return driver.findElement(By.xpath(String.format(productCheckoutOverviewLocator, productName)));
    }

    public String getProductPriceCheckoutOverview(String productName) {
        WebElement productCheckoutOverviewContainer = getProductCheckoutOverviewByName(productName);
        return productCheckoutOverviewContainer.findElement(productPriceCheckoutOverview).getText();
    }

    public String getProductDescriptionTextCheckoutOverview(String productName) {
        WebElement productCheckoutOverviewContainer = getProductCheckoutOverviewByName(productName);
        return productCheckoutOverviewContainer.findElement(descriptionTextCheckoutOverview).getText();
    }

    public String getQuantityProductCheckoutOverview(String productName) {
        WebElement productCheckoutOverviewContainer = getProductCheckoutOverviewByName(productName);
        return productCheckoutOverviewContainer.findElement(quantityProductCheckoutOverview).getText();
    }

    public String getPriceItemTotalText() {
        String priceItemTotalText = driver.findElement(priceItemTotal).getText();
        String[] itemTotalPrice = priceItemTotalText.split("\\$");
        return itemTotalPrice[1];
    }

    public String getPriceTaxText() {
        String priceTaxText = driver.findElement(priceTax).getText();
        String[] taxPrice = priceTaxText.split("\\$");
        return taxPrice[1];
    }

    public String getPriceTotalText() {
        String priceTotalText = driver.findElement(priceTotal).getText();
        String[] totalPrice = priceTotalText.split("\\$");
        return totalPrice[1];
    }

    public void clickCancelOverviewButton() {
        driver.findElement(cancelOverviewButton).click();
    }
    @Step("Click button 'Finish'")
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
