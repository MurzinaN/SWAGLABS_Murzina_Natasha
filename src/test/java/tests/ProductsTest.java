package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test(description = "Checking the availability of products in the catalog by name, price and description", groups = {"regression"}, dataProvider = "isProductInCatalogPresentTestData")
    public void isProductInCatalogPresentTest(String productName, String priceProduct, String description) {
        LoginPage.login(USER_NAME, PASSWORD);
        Assert.assertEquals(ProductsPage.getProductDescriptionText(productName), description, "Checking product description by product name");
        Assert.assertEquals(ProductsPage.getProductPrice(productName), priceProduct, "Checking product price by product name");
    }

    @DataProvider
    public Object[][] isProductInCatalogPresentTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."}
        };
    }

    @Test(description = "Logout", groups = {"regression"})
    public void logoutTest() {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.clickMenuButton();
        ProductsPage.clickLogoutButton();
        Assert.assertTrue(LoginPage.isLoginFormPresent());

    }
    public List<String> expectedProductNamesSortNameZToA() {
        List<String> expectedProductName = new ArrayList<String>();
        expectedProductName.add("Sauce Labs Bike Light");
        expectedProductName.add("Sauce Labs Fleece Jacket");
        expectedProductName.add("Sauce Labs Bolt T-Shirt");
        expectedProductName.add("Sauce Labs Backpack");
        expectedProductName.add("Test.allTheThings() T-Shirt (Red)");
        expectedProductName.add("Sauce Labs Onesie");
        Collections.sort(expectedProductName);
        Collections.reverse(expectedProductName);
        return expectedProductName;
    }

    @Test(description = "Checking the sorting of products in the catalog Z to A", groups = {"regression"})
    public void sortTestZToA() {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.clickSortNameZToA();
        ProductsPage.sortNameZToA();
        Assert.assertEquals(ProductsPage.sortNameZToA(), expectedProductNamesSortNameZToA());
    }


}
