package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest{
    final static String PRODUCT_NAME = "Sauce Labs Onesie";

    @Test
    public void itemDetailsShoppingCartTest(){
        LoginPage.login("standard_user", "secret_sauce");
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getProductShoppingCartPrice(PRODUCT_NAME), "$7.99");
        Assert.assertEquals(ShoppingCartPage.getProductDescriptionShoppingCartText(PRODUCT_NAME),"Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    }
    @Test
    public void clickRemoveShoppingCartTest(){
        LoginPage.login("standard_user", "secret_sauce");
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickRemoveButton(PRODUCT_NAME);
        Assert.assertTrue(ShoppingCartPage.productContainerShoppingCartMissing(PRODUCT_NAME));
    }

    @Test
    public void quantityShoppingCartTest(){
        LoginPage.login("standard_user", "secret_sauce");
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getQuantityProductShoppingCartText(PRODUCT_NAME), "1");
        }

}
