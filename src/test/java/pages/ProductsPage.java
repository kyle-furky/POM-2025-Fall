package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    private By firstAddToCartButton=By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private By cartIcon=By.className("shopping_cart_link");
    private By firstCartITenName=By.className("inventory_item_name");

    public void productsPage(WebDriver driver){
        this.driver=driver;
    }

    public void addFirstProductToCart(){
        driver.findElement(firstAddToCartButton).click();
    }

    public void clickCartIcon(){
        driver.findElement(cartIcon).click();
    }
    public String getFirstCartItemName(){
        return driver.findElement(firstCartITenName).getText();
    }

    public String getPageTitle() {
        return null;
    }
}
