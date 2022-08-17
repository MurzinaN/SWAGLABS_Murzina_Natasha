package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {
    final static String PRODUCT_NAME = "Sauce Labs Onesie";
    final static String COMPLETION_MESSAGE = "THANK YOU FOR YOUR ORDER";

    @Test(groups = {"smoke"})
    @Description("Entering correct data when placing an order")
    public void positiveCheckoutYourInfoTest() {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckoutPage.setFirstName("Jim");
        CheckoutPage.setLastName("Beam");
        CheckoutPage.setZip("12345");
        CheckoutPage.clickContinueButton();
        Assert.assertFalse(CheckoutPage.checkoutFormPresent(), "CheckoutForm shouldn't be on display");
    }

    @Test(groups = {"negative"}, dataProvider = "negativeCheckoutYourInfoTestData")
    @Description("Entering correct data when placing an order")
    public void negativeCheckoutYourInfoTest(String firstName, String lastName, String zip, String errorMessage) {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckoutPage.setFirstName(firstName);
        CheckoutPage.setLastName(lastName);
        CheckoutPage.setZip(zip);
        CheckoutPage.clickContinueButton();
        Assert.assertTrue(CheckoutPage.isCheckoutErrorMessageDisplayed(), "Error message should be on display");
        Assert.assertEquals(CheckoutPage.getCheckoutErrorMessageText(), errorMessage, "Error message should be 'Error: First Name is required'");
    }

    @DataProvider
    public Object[][] negativeCheckoutYourInfoTestData() {
        return new Object[][]{
                {"Jim", "", "", "Error: Last Name is required"},
                {"", "Beam", "", "Error: First Name is required"},
                {"", "", "123", "Error: First Name is required"},
                {"Jim", "Beam", "", "Error: Postal Code is required"},
                {"Jim", "", "123", "Error: Last Name is required"},
                {"", "Beam", "123", "Error: First Name is required"}
        };
    }

    @Test(groups = {"smoke"})
    @Description("Checkout")
    public void CheckoutTest() {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckoutPage.setFirstName("Jim");
        CheckoutPage.setLastName("Beam");
        CheckoutPage.setZip("12345");
        CheckoutPage.clickContinueButton();
        CheckoutOverviewPage.clickFinishButton();
        Assert.assertEquals(CheckoutCompletePage.getOrderCompletionMessageText(), COMPLETION_MESSAGE, "On display should be  message that the order has been successfully completed");
    }

}
