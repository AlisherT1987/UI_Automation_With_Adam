package com.cydeo.tests.week02;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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



    /*
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
     */

    @Test
    public void verifyAccountInfo() {
        signUp();

        WebElement label = driver.findElement(By.xpath("//h2[contains(.,'Enter Account Information')]"));

        Assert.assertTrue(label.isDisplayed());


    }
/*
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
 */

    @Test
    public void verifyAccountCreation() {
        signUp();

        //click mr
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click(); //MR
        // driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click(); ///MRS
        //enter passowrd
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test12345");
        //Select day
        WebElement selectDayElement = driver.findElement(By.xpath("//select[@id='days']"));

        Select select=new Select(selectDayElement);
        select.selectByVisibleText("1");

        //Select month
        WebElement selectMonthElement = driver.findElement(By.xpath("//select[@id='months']"));

        select=new Select(selectMonthElement);
        select.selectByVisibleText("January");

        //Select year
        //driver.findElement(By.id("years"));
        WebElement selectYearElement = driver.findElement(By.xpath("//select[@id='years']"));

        select=new Select(selectYearElement);
        select.selectByVisibleText("1989");


        //click first checkbox

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        //click second checkbox

        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();











    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }


    private void clickModule(String moduleName) {
        String locator = "//a[contains(.,'" + moduleName + "')]";
        driver.findElement(By.xpath(locator)).click();

    }

    private void signUp(){
        Faker faker = new Faker();
        String name = faker.name().firstName();

        String email = name + faker.number().numberBetween(1, 1000) + "@gmail.com";
//faker.internet().emailAddress()

        clickModule("Signup / Login");


        WebElement nameElement = driver.findElement(By.xpath("//input[@name='name']"));

        nameElement.sendKeys(name);

        WebElement emailElement = driver.findElement(By.xpath("(//input[@name='email'])[2]"));

        emailElement.sendKeys(email);

        driver.findElement(By.xpath("//button[.='Signup']")).click();

    }
}
