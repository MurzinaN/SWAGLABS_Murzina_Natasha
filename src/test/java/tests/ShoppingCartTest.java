package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ShoppingCartTest extends BaseTest {
    final static String PRODUCT_NAME = "Sauce Labs Onesie";

    @Test(groups = {"regression"})
    @Description("Verify information about the product in the shopping cart")
    public void itemDetailsShoppingCartTest() {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getProductShoppingCartPrice(PRODUCT_NAME), "$7.99", "Checking price in shopping cart");
        Assert.assertEquals(ShoppingCartPage.getProductDescriptionShoppingCartText(PRODUCT_NAME), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "Checking description in shopping cart");
    }

    @Test(groups = {"regression"})
    @Description("Removing products from the cart")
    public void clickRemoveShoppingCartTest() {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickRemoveButton(PRODUCT_NAME);
        Assert.assertFalse(ShoppingCartPage.productContainerShoppingCartPresent(PRODUCT_NAME), "The product shouldn't be visible in the shopping cart");
    }

    @Test(groups = {"regression"})
    @Description("Checking the quantity of goods of the same type in the basket")
    public void quantityShoppingCartTest() {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getQuantityProductShoppingCartText(PRODUCT_NAME), "1", "Checking the quantity of goods in the cart");
    }

}
