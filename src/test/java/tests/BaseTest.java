package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    protected final static String USER_NAME = "standard_user";
    protected final static String PASSWORD = "secret_sauce";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage LoginPage;
    protected ProductsPage ProductsPage;
    protected ItemDetailsPage ItemDetailsPage;
    protected ShoppingCartPage ShoppingCartPage;
    protected CheckoutPage CheckoutPage;
    protected CheckoutOverviewPage CheckoutOverviewPage;
    protected CheckoutCompletePage CheckoutCompletePage;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);
        ItemDetailsPage = new ItemDetailsPage(driver);
        ShoppingCartPage = new ShoppingCartPage(driver);
        CheckoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage = new CheckoutCompletePage(driver);
        testContext.setAttribute("driver", driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        this.driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
     /* @AfterClass(alwaysRun = true)
      public void finish() {
          this.driver.quit();
          }*/
}


