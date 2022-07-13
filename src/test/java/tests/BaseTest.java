package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
        protected WebDriver driver;

        public BaseTest() {
        }
    pages.LoginPage LoginPage;
    pages.ProductsPage ProductsPage;
    pages.ItemDetailsPage ItemDetailsPage;
    pages.ShoppingCartPage ShoppingCartPage;
    CheckoutPage CheckoutYourInfoPage;
    @BeforeClass
    public void initialise(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);
        ItemDetailsPage = new ItemDetailsPage(driver);
        ShoppingCartPage = new ShoppingCartPage(driver);
        CheckoutYourInfoPage = new CheckoutPage(driver);
    }
   @AfterClass
    public void finish() {
        this.driver.quit();
        }
    @BeforeMethod
    public void navigate() {
        this.driver.get("https://www.saucedemo.com/");
        }
    }

