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

public class TC001 extends VytrackBase {
/*
TC 1- As a user I should be able to see the labels [“Home”,”About us”,”Our Approach”,”Products and Services”,”Contact”,”LOGIN”]
1- Open a chrome browser
2- Go to "https://vytrack.com/"
3- Verify that ["Home","About us","Our Approach","Products and Services","Contact","LOGIN"] is displayed
 */

    @Test
    public void verifyMenuLabels() {
        List<String> expectedLabels=new ArrayList<>((Arrays.asList("Home", "About us", "Our Approach", "Products and" +
                " Services", "Contact", "LOGIN")));

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='top-menu']/li"));
      List<String> actualLabels=  BrowserUtils.getTexts(elements);
        System.out.println("actualLabels = " + actualLabels);
        System.out.println("expectedLabels = " + expectedLabels);
        Assert.assertEquals(actualLabels,expectedLabels);

    }
}
