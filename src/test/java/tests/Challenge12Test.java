package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Challenge12Test extends BaseTest {

    // DataProvider supplies multiple sets of login data
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},   // valid credentials
                {"locked_out_user", "secret_sauce", false}, // locked account
                {"wrong_user", "wrong_pass", false}        // invalid credentials
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, boolean expectedResult) {
        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        if (expectedResult) {
            // Successful login should go to ProductsPage
            ProductsPage productsPage = new ProductsPage(driver);
            Assert.assertTrue(productsPage.isPageDisplayed(),
                    "Products page should be displayed for valid login");
        } else {
            // Failed login should show error
            Assert.assertTrue(loginPage.isErrorDisplayed(),
                    "Error message should be displayed for invalid login");
        }
    }
}
