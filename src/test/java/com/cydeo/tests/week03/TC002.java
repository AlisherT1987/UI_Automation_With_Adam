package com.cydeo.tests.week03;

import com.cydeo.tests.base.VytrackBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC002 extends VytrackBase {
/*
TC 2- As a user I should be able to see the labels ["Our Mission and Vision","Car Fleet Management","Newest Technologies"] under Our Approach
1- Open a chrome browser
2- Go to "https://vytrack.com/""
3- Verify that ["Our Mission and Vision","Car Fleet Management","Newest Technologies"] is displayed
 */


    @Test
    public void test1() {
        driver.findElement(By.xpath("//ul[@id='top-menu']/li[3]")).click();
        BrowserUtils.sleep(1);
        //List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='top-menu']/li[3]/ul/li"));
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='top-menu']/li[3]/ul/li[4]/preceding-sibling::li"));
        List<String> actualLabels = BrowserUtils.getTexts(elements); //we have for labels
        List<String> expectedLabels=new ArrayList<>(Arrays.asList("Our Mission and Vision","Car Fleet Management",
                "Newest Technologies"));
/*
        for (String expectedLabel : expectedLabels) {
            Assert.assertTrue(actualLabels.contains(expectedLabel));
        }

 */
        Assert.assertEquals(actualLabels,expectedLabels);

    }








}
