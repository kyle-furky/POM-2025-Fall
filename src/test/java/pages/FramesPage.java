package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BaseTest {

    private By frame1= By.id("frame1");
    private By frame2= By.id("frame2");
    private By headingText= By.id("sampleHeading");

    public FramesPage(WebDriver driver){
        this.driver=driver;
        this.driver.get("https://demoqa.com/frames");
    }
    public void switchToFrame1(){
        driver.switchTo().frame(driver.findElement(frame1));
    }
    public void switchToFrame2(){
        driver.switchTo().frame(driver.findElement(frame2));
    }

    public String getFrameText(){
        return driver.findElement(headingText).getText();
    }



}
