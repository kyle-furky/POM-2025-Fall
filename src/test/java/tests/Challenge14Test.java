package tests;
// This test class is inside the 'tests' package

import base.BaseTest;
// We extend BaseTest to reuse setup/teardown (driver init & quit)

import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
// Import our Page Object classes to interact with the app’s pages

import org.testng.Assert;
import org.testng.annotations.Test;
// Import TestNG annotations and assertions

/**
 * Challenge 14 Test:
 * Verify that adding a product from the Products page
 * is correctly reflected in the Cart page.
 */
public class Challenge14Test extends BaseTest {
// Extend BaseTest so we inherit WebDriver setup/teardown

    @Test
    // Marks this method as a TestNG test case
    public void verifyAddToCartFunctionality() {
        // -------- Step 1: Login --------
        LoginPage loginPage = new LoginPage(driver);
        // Create LoginPage object, pass the driver from BaseTest

        ProductsPage productsPage = loginPage.loginAs("standard_user", "secret_sauce");
        // Use the loginAs method to log in with valid credentials
        // This returns a ProductsPage object (since login is successful)

        Assert.assertTrue(productsPage.isPageDisplayed(), "Products page should be displayed");
        // Verify that the Products page is visible after login


        // -------- Step 2: Add first product to cart --------
        productsPage.addFirstProductToCart();
        // Click the "Add to cart" button for the first product

        String addedProductName = productsPage.getFirstCartItemName();
        // Save the product’s name (to later compare it with cart contents)


        // -------- Step 3: Go to cart --------
        productsPage.clickCartIcon();
        // Click on the shopping cart icon in the header

        CartPage cartPage = new CartPage(driver);
        // Create CartPage object after navigating to cart


        // -------- Step 4: Verify Cart Page --------
        Assert.assertTrue(cartPage.isPageDisplayed(), "Cart page should be displayed");
        // Confirm we are indeed on the Cart page (by checking "Your Cart" title)


        // -------- Step 5: Verify Product Match --------
        String cartProductName = cartPage.getCartItemName();
        // Get the product name shown in the cart

        Assert.assertEquals(cartProductName, addedProductName,
                "The product in the cart should match the one added from Products page");
        // Compare the product added to cart with the product actually shown in the cart
    }
}
