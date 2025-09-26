package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Challenge16Test extends BaseTest {

    @Test
    public void testInvalidLoginShowsErrorMessage(){
        //create login object
        LoginPage loginPage=new LoginPage(driver);
        //enter invalid username+password
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
        //click login
        loginPage.clickLoginButton();
        //step4 capture adn verify error message
        String errorMsg= loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg.contains("Epic sad face"),
                "Expected error message not displayed");

    }



}
