package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HomePage extends BasePage {
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By allItemsButton = By.id("inventory_sidebar_link");
    private final By aboutButton = By.id("inventory_sidebar_link");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By resetAppStateButton = By.id("reset_sidebar_link");
    private final By shoppingCartButton = By.id("shopping_cart_container");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void clickAllItemsButton() {
        driver.findElement(allItemsButton).click();
    }

    public void clickAboutButton() {
        driver.findElement(aboutButton).click();
    }

    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public void clickResetAppStateButton() {
        driver.findElement(resetAppStateButton).click();
    }

    public void clickShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
    }
}
