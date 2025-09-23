package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageChallenge15 {

    WebDriver driver;

    //locator
    private By checkoutButton = By.id("checkout");

    //constructor
    public CartPageChallenge15(WebDriver driver){
        this.driver=driver;
    }

    // click checkout button
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }


}
