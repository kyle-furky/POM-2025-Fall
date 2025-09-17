package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By searchBox= By.id("searchbox");
    private By searchButton=By.id("searchBtn");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void enterSearchTest(String text){
        driver.findElement(searchBox).sendKeys(text);
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }


}
