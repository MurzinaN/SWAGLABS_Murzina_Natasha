package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;

public class ItemDetailsTest extends BaseTest{
    final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";

    @Test
    public void verifyItemNameAndPriceOnDetailsPage() {
        LoginPage.login("standard_user", "secret_sauce");
        ProductsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(ItemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(ItemDetailsPage.getItemPrice(), "$49.99");
        Assert.assertEquals(ItemDetailsPage.getItemDescription(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
    }
}
