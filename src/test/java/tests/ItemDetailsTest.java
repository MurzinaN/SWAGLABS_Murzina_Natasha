package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ItemDetailsTest extends BaseTest {


    @Test(groups = {"regression"}, dataProvider = "ProductInformationOnDetailPage")
    @Description("Check information about the selected product on the details page")
    public void verifyProductInformationOnDetailPage(String productName, String priceProduct, String description) {
        LoginPage.login(USER_NAME, PASSWORD);
        ProductsPage.openItemByName(productName);
        Assert.assertEquals(ItemDetailsPage.getItemName(), productName, "Checking product name");
        Assert.assertEquals(ItemDetailsPage.getItemPrice(), priceProduct, "Checking price");
        Assert.assertEquals(ItemDetailsPage.getItemDescription(), description, "Checking description");
    }

    @DataProvider
    public Object[][] ProductInformationOnDetailPage() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."}
        };
    }

}
