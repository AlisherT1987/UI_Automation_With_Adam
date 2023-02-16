package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
This class will be storing only the utility methods that can be used across the project.
 */
public class BrowserUtils {

    /*
    This method will accept int (in seconds)
    and execute Thread.sleep method for given duration
    Arg: int second
     */
    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle){

        //Return and store all window handles in a Set.
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInURL )){
                break;
            }
        }

        //5. Assert:Title contains “Etsy”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
    public static void verifyTitleContains(WebDriver driver, String expectedInTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }

    public static List<String> getTexts(List<WebElement> elements) {

        List<String> result=new ArrayList<>();

        for (WebElement element : elements) {

            String eachText = element.getText();
            result.add(eachText);

        }

        return result;

    }


    public static void scrollToElement(WebElement element){
        Actions actions=new Actions(Driver.getDriver());
        actions.scrollToElement(element).perform();
    }

    public static void scrollToElement(By by){
        Actions actions=new Actions(Driver.getDriver());
        actions.scrollToElement(Driver.getDriver().findElement(by)).perform();
    }

    public static void clickElement(WebElement element){
        //I need to have one condition for visibility
        waitForVisibilityOf(element);
        element.click();
    }

    public static void clickElement(By by){
        //I need to have one condition for visibility
       WebElement element= Driver.getDriver().findElement(by);
        waitForVisibilityOf(element);
        element.click();
    }
    public static void waitForVisibilityOf(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
