package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private By title = By.className("title");


    public ProductsPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getPageTitle(){
        return driver.findElement(title).getText();
    }
}
