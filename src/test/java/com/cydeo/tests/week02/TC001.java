package com.cydeo.tests.week02;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC001 {
    WebDriver driver;
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
     */
    @BeforeMethod
    public void setUp() {
         driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://automationexercise.com");

    }


    @Test
    public void verifyHomePage() {
      /* String expectedTitle="Automation Exercise";
        String actualTitle = driver.getTitle();
                               //actual     expected
        Assert.assertEquals(actualTitle,expectedTitle);

       */
        BrowserUtils.verifyTitle(driver,"Automation Exercise");

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
