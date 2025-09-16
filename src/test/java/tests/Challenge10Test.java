package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class Challenge10Test extends BaseTest {

    @Test
    public void testLoginToSauceDemo(){
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage =  loginPage.loginAs(
                "standart_user", "secret_sauce");
        Assert.assertEquals(productsPage.getPageTitle(), "Products",
                "Login failed or wrong password");

    }



}
