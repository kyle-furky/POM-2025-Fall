package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage {

    WebDriver driver;

    //locators
    private By newTabButton= By.id("tabButton");
    private By headingText=By.id("sampleHeading");

    //store window handles
    private String mainTabHandle;

    public BrowserWindowsPage(WebDriver driver){
        this.driver=driver;
        this.driver.get("https://demoqa.com/browser-windows");
        // store main tab handle
        this.mainTabHandle=driver.getWindowHandle();
    }

    public void clickNewTabButton(){
        driver.findElement(newTabButton).click();
    }

    public void switchToNewTab(){
        List<String> handles=new ArrayList<>(driver.getWindowHandles());
        for (String handle : handles) {
             if (!handle.equals(mainTabHandle)){
                 driver.switchTo().window(handle);
                 break;
            }
        }
    }

    public String getNewTabHeadingText(){
        return driver.findElement(headingText).getText();
    }
    public void switchToMainTab(){
        driver.switchTo().window(mainTabHandle);
    }

}
