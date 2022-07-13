package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest{


    @Test
    public void positiveLoginTest(){
        LoginPage.setUserName("standard_user");
        LoginPage.setPassword("secret_sauce");
        LoginPage.clickLoginButton();
        Assert.assertTrue(ProductsPage.isProductsPageHeaderDisplayed(), "ProductsPageHeader should be on display");
    }

    @Test
    public void negativeLoginTest(){
        LoginPage.setUserName("");
        LoginPage.setPassword("secret_sauce");
        LoginPage.clickLoginButton();
        Assert.assertTrue(LoginPage.isErrorMessageDisplayed(), "Error message should be on display");
        Assert.assertEquals(LoginPage.getErrorMessageTest(),"Epic sadface: Username is required", "Error message should be 'Epic sadface: Username is required'");
    }

}
