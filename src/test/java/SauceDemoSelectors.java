import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SauceDemoSelectors extends BaseTest{

    @Test
    public void sauceDemoTest(){
        WebElement userName = driver.findElement(By.cssSelector("[placeholder='Username']"));
        WebElement userNameStandard = driver.findElement(By.cssSelector("#login_credentials"));
        String textName[] = userNameStandard.getText().split("\n");
        String standardUser = textName[1];
        userName.sendKeys(standardUser);
        WebElement password = driver.findElement(By.cssSelector("[type~='password']"));
        WebElement passwordForAll = driver.findElement(By.xpath("//div[@class='login_password']"));
        String textPassword[] = passwordForAll.getText().split("\n");
        String secretSauce = textPassword[1];
        password.sendKeys(secretSauce);
        WebElement loginButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        loginButton.click();
        WebElement anyProduct = driver.findElement(By.xpath("//*[@class='inventory_item'][5]//*[contains(@class,'name')]"));
        anyProduct.click();
        WebElement productName = driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']"));
        String selectedProductName = productName.getText();
        WebElement productPrice = driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']/following-sibling::div[contains(@class,'price')]"));
        String selectedProductPrice = productPrice.getText();
        WebElement productButton = driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']/following-sibling::button"));
        productButton.click();
        WebElement shoppingCart = driver.findElement(By.tagName("span"));
        shoppingCart.click();
        WebElement productNameInCart = driver.findElement(By.xpath("//*[@class='cart_item']/descendant::div[contains(@class,'name')]"));
        String actualProductName = productNameInCart.getText();
        WebElement productPriceInCart = driver.findElement(By.xpath("//*[@class='cart_item']/descendant::div/div/div[contains(@class,'price')]"));
        String actualProductPrice = productPriceInCart.getText();
        Assert.assertEquals(actualProductName, selectedProductName, "checking the name of the product in the catalogs basket");
        Assert.assertEquals(actualProductPrice, selectedProductPrice, "checking the price of the product in the catalogs basket");


    }
}
