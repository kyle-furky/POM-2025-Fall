package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class Challenge17Test extends BaseTest {

    @Test
    public void testSortProductsByPriceLowToHigh(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername("standart_user");
        loginPage.enterPassword("secret_sauce");
        ProductsPage productsPage=loginPage.clickLoginButton();

        productsPage.selectSortingOption("Price low to high");

        List<Double> prices=productsPage.getAllProductPrices();

        //verify prices are sorted in ascending order
        for (int i=0; i<prices.size();i++){
            Assert.assertTrue(prices.get(i) <= prices.get(i+1),
                    "Products are not sorted by price low to high!");

        }

    }

}
