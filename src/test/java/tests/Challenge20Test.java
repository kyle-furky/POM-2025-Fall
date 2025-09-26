package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;
import pages.FramesPage;

public class Challenge20Test extends BaseTest {

    @Test
    public void testSwitchBetweenIFrames(){
        FramesPage framesPage=new FramesPage(driver);

        //switch to 1st frame
        framesPage.switchToFrame1();
        String textFrame1= framesPage.getFrameText();
        driver.switchTo().defaultContent(); //return to main page

        //switch to 2nd frame
        framesPage.switchToFrame2();
        String textFrame2=framesPage.getFrameText();
        driver.switchTo().defaultContent(); //back to main

        //verify both frame texts
        Assert.assertEquals(textFrame1, "This is a sample page");
        Assert.assertEquals(textFrame2, "This is a sample page");

    }

    @Test
    public void testHandleNewTab() {
        BrowserWindowsPage windowsPage = new BrowserWindowsPage(driver);

        //click
        windowsPage.clickNewTabButton();
        //switch
        windowsPage.switchToNewTab();
        //verify
        String heading = windowsPage.getNewTabHeadingText();
        Assert.assertEquals(heading, "This is sample page");
        //switch back to main
        windowsPage.switchToMainTab();
    }
}
