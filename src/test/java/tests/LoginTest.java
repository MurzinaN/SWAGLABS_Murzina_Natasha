package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest{


    @Test
    public void positiveLoginTest(){
        LoginPage.setUserName("standard_user");
        LoginPage.setPassword("secret_sauce");
        LoginPage.clickLoginButton();
        Assert.assertTrue(ProductsPage.isProductsPageHeaderDisplayed());
    }

    @Test
    public void negativeLoginTest(){
        LoginPage.setUserName("");
        LoginPage.setPassword("secret_sauce");
        LoginPage.clickLoginButton();
        Assert.assertTrue(LoginPage.isErrorMessageDisplayed());
        Assert.assertEquals(LoginPage.getErrorMessageTest(),"Epic sadface: Username is required");
    }

}
