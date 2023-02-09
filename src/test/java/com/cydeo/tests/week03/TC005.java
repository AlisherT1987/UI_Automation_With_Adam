package com.cydeo.tests.week03;

import com.cydeo.tests.base.HerokuAppBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005 extends HerokuAppBase {
    /*
    TC 5: As a User I should be able to see BOTTOM label
    1- Open a chrome browser
    2- Go to https://the-internet.herokuapp.com/
    3- Click Nested Frames
    4- Verify the BOTTOM label
     */
    @Test
    public void test1() {
        clickOption("Nested");

        driver.switchTo().frame("frame-bottom");
        WebElement element = driver.findElement(By.xpath("//body"));
        String actualText = element.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertEquals(actualText,"BOTTOM");
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
         element = driver.findElement(By.xpath("//body"));
        actualText = element.getText();
        System.out.println("actualText = " + actualText);

       driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        element = driver.findElement(By.xpath("//body"));
        actualText = element.getText();
        System.out.println("actualText = " + actualText);

    }

    public void clickOption(String option) {
        ////a[contains(.,'Nested')]
        //first part of locator     dynamic pat        last part
        //  String dynamicLocatorOOption= "//a[contains(.,'"      +   option    +   "')]" ;
        String locator = "//a[contains(.,'" + option + "')]";

        driver.findElement(By.xpath(locator)).click();
    }
}
