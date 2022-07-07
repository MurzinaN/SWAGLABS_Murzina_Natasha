import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
        protected WebDriver driver;

        public BaseTest() {
        }
        @BeforeClass
        public void start() {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
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

