package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest{
    final static String PRODUCT_NAME = "Sauce Labs Onesie";
    String firstNameErrorMessage = "Error: First Name is required";
    String lastNameErrorMessage = "Error: Last Name is required";

    @Test
    public void positiveCheckoutYourInfoTest(){
        LoginPage.login("standard_user", "secret_sauce");
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckoutYourInfoPage.setFirstName("Jim");
        CheckoutYourInfoPage.setLastName("Beam");
        CheckoutYourInfoPage.setZip("12345");
        CheckoutYourInfoPage.clickContinueButton();
        Assert.assertTrue(CheckoutYourInfoPage.checkoutFormPresent(), "CheckoutForm shouldn't be on display");
    }

    @Test
    public void negativeEmptyFormCheckoutYourInfoTest(){
        LoginPage.login("standard_user", "secret_sauce");
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckoutYourInfoPage.setFirstName("");
        CheckoutYourInfoPage.setLastName("");
        CheckoutYourInfoPage.setZip("");
        CheckoutYourInfoPage.clickContinueButton();
        Assert.assertTrue(CheckoutYourInfoPage.isCheckoutErrorMessageDisplayed(), "Error message should be on display");
        Assert.assertEquals(CheckoutYourInfoPage.getCheckoutErrorMessageText(),firstNameErrorMessage, "Error message should be 'Error: First Name is required'");
    }

    @Test
    public void negativeOnlyFirstNameCheckoutYourInfoTest(){
        LoginPage.login("standard_user", "secret_sauce");
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckoutYourInfoPage.setFirstName("Jim");
        CheckoutYourInfoPage.setLastName("");
        CheckoutYourInfoPage.setZip("");
        CheckoutYourInfoPage.clickContinueButton();
        Assert.assertTrue(CheckoutYourInfoPage.isCheckoutErrorMessageDisplayed(), "Error message should be on display");
        Assert.assertEquals(CheckoutYourInfoPage.getCheckoutErrorMessageText(),lastNameErrorMessage, "Error message should be 'Error: Last Name is required'");
    }

}
