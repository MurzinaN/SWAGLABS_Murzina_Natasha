package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import tests.TestListener;
import utils.Screen;

public class LoginPage extends BasePage {
    final By loginForm = By.id("login_button_container");
    @FindBy(id = "user-name")
    WebElement usernameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = ".error-message-container")
    WebElement errorMassage;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    @Step("Set username: {userName}")
    public void setUserName(String userName) {
        usernameInput.sendKeys(userName);
        Screen.attachScreenshot(driver);
    }
    @Step("Set password")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
        Screen.attachScreenshot(driver);
    }
    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click();
        Screen.attachScreenshot(driver);
    }
    @Step("Ñhecking the presence of error message on display")
    public boolean isErrorMessageDisplayed() {
        return errorMassage.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMassage.getText();
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }
    public void waitLoginForm() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
    }

    public boolean isLoginFormPresent() {
        return driver.findElement(loginForm).isDisplayed();
    }
}
