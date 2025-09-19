package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class Challenge11Test extends BaseTest {



    @Test
    public void testAddProductToCart(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standart-user");
        loginPage.enterPassword("secret_sauce");


    }

}
