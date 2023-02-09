package com.cydeo.tests.week03;

import com.cydeo.tests.base.TrycloudBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004 extends TrycloudBase {

    /*
    TC 4- As a user I should be able to see the password hidden
1- Open a chrome browser
2- Go to "http://qa2.trycloud.net/index.php/login"
3- Login with valid credentials
4- Verify that password s hidden
     */

    @Test
    public void verifyPasswordIsHiddenDefault() {
        WebElement passwordElement = driver.findElement(By.cssSelector("input[name='password']"));
        passwordElement.sendKeys("Abcd123");
        System.out.println("value of type " + passwordElement.getAttribute("type"));
        String expectedValue="password";
        String actualValue = passwordElement.getAttribute("type");

        Assert.assertEquals(actualValue,expectedValue);

    }
}
