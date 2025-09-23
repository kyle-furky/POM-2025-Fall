package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPageChallenge15;
import pages.CheckoutPageChallenge15;
import pages.LoginPage;
import pages.ProductsPage;

public class Challenge15Test extends BaseTest {

    @Test
    public void testCompleteCheckoutFlow(){


        //1 Login
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        ProductsPage productsPage=loginPage.clickLoginButton();

        //2 add a products to the cart
        productsPage.addFirstProductToCart();
        productsPage.clickCartIcon();

        //3 go to cart page
        CartPageChallenge15 cartPageChallenge15=new CartPageChallenge15(driver);
        cartPageChallenge15.clickCheckoutButton();

        //4 go to checkout page and fill info
        CheckoutPageChallenge15 checkoutPageChallenge15=new CheckoutPageChallenge15(driver);
        checkoutPageChallenge15.enterFirstName("kyle");
        checkoutPageChallenge15.enterLastName("furky");
        checkoutPageChallenge15.enterPostalCode("20215");
        checkoutPageChallenge15.clickContinue();

        //5 finish checkout
        checkoutPageChallenge15.clickFinish();

        //6 verify confirmation message
        String confirmation = checkoutPageChallenge15.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order",
        "Checkout confirmation message mismatch");

    }
}
