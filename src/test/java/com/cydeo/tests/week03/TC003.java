package com.cydeo.tests.week03;

import com.cydeo.tests.base.VytrackBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003 extends VytrackBase {
/*
TC 3 - As a user I should be able to see Fleet Analysis and Optimization Page
1- Open a chrome browser
2- Go to "https://vytrack.com/"
3- Click Products and Services
4- Click Fleet analysis and optimization
5- Verify the page and label

 */

    @Test
    public void test1() {
       clickSubMenu("Product","Fleet");
        Assert.assertTrue(driver.getCurrentUrl().contains("fleet-analysis-and-optimization"));

    }

    @Test
    public void test2() {
        clickSubMenu("Product","Damage");
        Assert.assertTrue(driver.getCurrentUrl().contains("damage-management"));

    }

    public void clickSubMenu(String main, String subMenu) {
        clickMain(main);
        String sublocator="//ul[@id='top-menu']/li[contains(.,'"+main+"')]/ul/li[contains(.,'"+subMenu+"')]";
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath(sublocator)).click();

    }

    public void clickMain(String main) {
        String locator = "//ul[@id='top-menu']/li[contains(.,'" + main + "')]";
        driver.findElement(By.xpath(locator)).click();
    }

}
