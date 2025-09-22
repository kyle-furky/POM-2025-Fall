package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Challenge13Test extends BaseTest {

    @Test
    public void verifyAllProductsAreDisplayed() {
        // Step 1: Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Step 2: Navigate to Products page
        ProductsPage productsPage = new ProductsPage(driver);

        // Step 3: Verify Products page is displayed
        Assert.assertTrue(productsPage.isPageDisplayed(),
                "Products page should be displayed after successful login");

        // Step 4: Verify product count (SauceDemo has 6 products)
        int productCount = productsPage.getProductCount();
        Assert.assertEquals(productCount, 6,
                "Expected 6 products, but found " + productCount);
    }
}
