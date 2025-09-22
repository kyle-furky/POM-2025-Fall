package pages;  // The CartPage class is inside the 'pages' package

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * CartPage represents the "Your Cart" page of the SauceDemo website.
 * It contains locators and methods to interact with the cart screen.
 */
public class CartPage {
    private WebDriver driver; // WebDriver instance for browser control

    // --- Locators ---
    private By cartItemName = By.className("inventory_item_name");
    // Finds the name of items inside the cart (like "Sauce Labs Backpack")

    private By cartTitle = By.cssSelector(".title");
    // The page title element that shows "Your Cart"


    // --- Constructor ---
    public CartPage(WebDriver driver) {
        // When we create a CartPage object, we pass the driver from the test
        this.driver = driver;
    }


    // --- Methods (Actions + Validations) ---

    /**
     * Get the name of the first item in the cart.
     * @return String - product name
     */
    public String getCartItemName() {
        // Locate the product name and return its text
        return driver.findElement(cartItemName).getText();
    }

    /**
     * Verify if we are on the Cart Page.
     * @return boolean - true if "Your Cart" title is displayed
     */
    public boolean isPageDisplayed() {
        // 1. Check if the title element exists
        // 2. Ensure it is visible
        // 3. Confirm the text equals "Your Cart"
        return driver.findElements(cartTitle).size() > 0
                && driver.findElement(cartTitle).isDisplayed()
                && driver.findElement(cartTitle).getText().equals("Your Cart");
    }
}
