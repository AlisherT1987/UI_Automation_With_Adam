package com.cydeo.tests.week02;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC001 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://automationexercise.com");

    }
  /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
     */

    @Test
    public void verifyHomePage() {
      /* String expectedTitle="Automation Exercise";
        String actualTitle = driver.getTitle();
                               //actual     expected
        Assert.assertEquals(actualTitle,expectedTitle);

       */
        BrowserUtils.verifyTitle(driver, "Automation Exercise");

    }

    /*
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
     */


    @Test
    public void verifyNewUserSignUpLabel() {
        BrowserUtils.sleep(1);
        clickModule("Signup / Login");
        BrowserUtils.sleep(2);
        WebElement labelForSignUp = driver.findElement(By.xpath("//h2[.='New User Signup!']"));

        Assert.assertTrue(labelForSignUp.isDisplayed());
        //option + Enter for creating method (mac)
        //alt+enter (windows)

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }


    private void clickModule(String moduleName) {
        String locator = "//a[contains(.,'" + moduleName + "')]";
        driver.findElement(By.xpath(locator)).click();

    }
}
