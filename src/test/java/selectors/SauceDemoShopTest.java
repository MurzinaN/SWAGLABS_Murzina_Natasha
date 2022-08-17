package selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class SauceDemoShopTest extends BaseTest {

    public void swagLabsTest() {
        WebElement userName = driver.findElement(By.cssSelector("[placeholder='Username']"));
        WebElement userNameStandard = driver.findElement(By.cssSelector("#login_credentials"));
        WebElement password = driver.findElement(By.cssSelector("[type~='password']"));
        WebElement backToProducts = driver.findElement(By.cssSelector(".left_component"));
        WebElement loginBoxButton = driver.findElement(By.cssSelector(".login-box .submit-button"));
        WebElement shoppingCart = driver.findElement(By.cssSelector("a span"));
        WebElement sortButton = driver.findElement(By.cssSelector("select.product_sort_container"));
        WebElement imageId = driver.findElement(By.cssSelector("[id^='item_4_img']"));
        WebElement menuButton = driver.findElement(By.cssSelector("[style$='1000;']"));
        WebElement userNameId = driver.findElement(By.cssSelector("[id*='user']"));
        WebElement menuButtonId = driver.findElement(By.cssSelector("[id|='react-burger-menu']"));
        WebElement passwordForAll = driver.findElement(By.xpath("//div[@class='login_password']"));
        WebElement loginButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        WebElement anyProduct = driver.findElement(By.xpath("//*[@class='inventory_item'][5]//*[contains(@class,'name')]"));
        WebElement productName = driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']"));
        WebElement productPrice = driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']/following-sibling::div[contains(@class,'price')]"));
        WebElement productButton = driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']/following-sibling::button"));
        WebElement productNameInCart = driver.findElement(By.xpath("//*[@class='cart_item']/descendant::div[contains(@class,'name')]"));
        WebElement productPriceInCart = driver.findElement(By.xpath("//*[@class='cart_item']/descendant::div/div/div[contains(@class,'price')]"));
        WebElement productNameText = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        WebElement productPartNameText = driver.findElement(By.xpath("//div[contains(text(),'Onesie')]"));
        WebElement productPriceFromName = driver.findElement(By.xpath("//div[contains(text(),'Onesie')]//ancestor::div[2]/div/div[contains(@class,'price')]"));
        WebElement detailsContainer = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']/parent::div"));
        WebElement productDesc = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']/preceding-sibling::div[2]"));
        WebElement login = driver.findElement(By.xpath("//*[@data-test='username' and @type='text']"));
        WebElement shoppingCartTag = driver.findElement(By.tagName("span"));
        WebElement productIdt = driver.findElement(By.id("item_1_title_link"));
        WebElement buttonName = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        WebElement buttonLoginName = driver.findElement(By.className("submit-button"));

    }
}
