package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(description = "Authorization check with correct data", groups = {"smoke"})
    public void positiveLoginTest() {
        LoginPage.login(USER_NAME, PASSWORD);
        Assert.assertTrue(ProductsPage.isProductsPageHeaderDisplayed(), "ProductsPageHeader should be on display");
    }

    @Test(description = "Authorization check with incorrect data", groups = {"negative"}, dataProvider = "negativeLoginTestData")
    public void negativeLoginTest(String userName, String password, String errorMessage) {
        LoginPage.setUserName(userName);
        LoginPage.setPassword(password);
        LoginPage.clickLoginButton();
        Assert.assertTrue(LoginPage.isErrorMessageDisplayed(), "Error message should be on display");
        Assert.assertEquals(LoginPage.getErrorMessageText(), errorMessage, "Error message should be: " + errorMessage);
    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"abc", "abc", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

}
