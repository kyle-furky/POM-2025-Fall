package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    private By firstAddToCartButton=By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private By cartIcon=By.className("shopping_cart_link");
    private By firstCartITenName=By.className("inventory_item_name");

    private By productsTitle = By.cssSelector(".title");          // Header "Products"
    private By inventoryItems = By.className("inventory_item");   // All product items on the page






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

    // Validation: check if Products page is displayed
    public boolean isPageDisplayed() {
        return driver.findElements(productsTitle).size() > 0
                && driver.findElement(productsTitle).isDisplayed()
                && driver.findElement(productsTitle).getText().equals("Products");
    }

    // Get number of products listed on the page
    public int getProductCount() {
        return driver.findElements(inventoryItems).size();
    }

    // Example: check if a specific product exists
    public boolean isProductDisplayed(String productName) {
        By productLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");
        return driver.findElements(productLocator).size() > 0;
    }
}
