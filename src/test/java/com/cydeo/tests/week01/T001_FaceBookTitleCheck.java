package com.cydeo.tests.week01;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T001_FaceBookTitleCheck {

    public static void main(String[] args) {

        //  TC #1: Facebook title verification
        //  1. Open Chrome browser
        WebDriverManager.chromedriver().setup();

        //  2. Go to https://www.facebook.com
        WebDriver driver = new ChromeDriver(); //polymorphism
        driver.manage().window().maximize();   //method chaining
        String url = "https://www.facebook.com";
        driver.get(url);
        //  3. Verify title:
        //  Expected: “Facebook – log in or sign up”
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
        }


//wait before closing
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

//close the browser
        driver.close();

    }


}
