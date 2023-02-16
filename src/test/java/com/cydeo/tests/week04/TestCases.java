package com.cydeo.tests.week04;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.pages.HoversPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {

    //for mac command + N
    //for windows alt +insert
    CydeoPracticePage cydeoPracticePage;
    HoversPage hoversPage;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.practice.url"));
        cydeoPracticePage = new CydeoPracticePage();
        hoversPage = new HoversPage();
    }
    /*
    TC-1 Verify user1 , user2 , user3 is displaying

1- Open browser
2- Click Hovers
3- Verify user1 , user2 , user3 is displaying
     */

    @Test
    public void test1() {
        cydeoPracticePage.clickOption("Hovers");
        hoversPage.hoverOverUser(1);
        String username = hoversPage.getUserName(1);
        Assert.assertTrue(username.contains("1"));

    }

    @Test
    public void test2() {
        cydeoPracticePage.clickOption("Hovers");
        hoversPage.hoverOverUser(2);
        String username = hoversPage.getUserName(2);
        Assert.assertTrue(username.contains("2"));

    }

    @Test
    public void test3() {
        int usernumber =3;
        cydeoPracticePage.clickOption("Hovers");
        hoversPage.hoverOverUser(usernumber);
        String username = hoversPage.getUserName(usernumber);
        Assert.assertTrue(username.contains(usernumber+""));

    }
  //@AfterMethod  //we can try wit After Method we can see the differences With Singleton Design Driver class
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
