package com.cydeo.tests.week04;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.pages.HoversPage;
import com.cydeo.pages.KeyPressPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCases {

    //for mac command + N
    //for windows alt +insert
    CydeoPracticePage cydeoPracticePage;
    HoversPage hoversPage;
    KeyPressPage keyPressPage;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.practice.url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        cydeoPracticePage = new CydeoPracticePage();
        hoversPage = new HoversPage();
        keyPressPage=new KeyPressPage();
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

    @Test
    public void test4() {
        cydeoPracticePage.clickOption("Key Presses");

        keyPressPage.clickKey(Keys.SHIFT);
        BrowserUtils.sleep(2);
        Assert.assertTrue(keyPressPage.result.getText().contains("SHIFT"));

    }

    @Test
    public void test5() {
        cydeoPracticePage.clickOption("Key Presses");

        keyPressPage.clickKey(Keys.TAB);
        BrowserUtils.sleep(2);
        Assert.assertTrue(keyPressPage.result.getText().contains("TAB"));

    }

    //@AfterMethod  //we can try wit After Method we can see the differences With Singleton Design Driver class
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
