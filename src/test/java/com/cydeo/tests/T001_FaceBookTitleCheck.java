package com.cydeo.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T001_FaceBookTitleCheck {

    public static void main(String[] args) {

        //  TC #1: Facebook title verification
        //  1. Open Chrome browser
        WebDriverManager.chromedriver().setup();

        //  2. Go to https://www.facebook.com
        WebDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com";
        driver.get(url);
        //  3. Verify title:
        //  Expected: “Facebook – log in or sign up”
        String expectedTitle="Facebook – log in or sign up";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else {
            System.err.println("FAIL");
        }


        //close the browser

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }


        driver.close();

    }


}
