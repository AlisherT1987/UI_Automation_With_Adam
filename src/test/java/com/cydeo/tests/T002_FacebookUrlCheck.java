package com.cydeo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T002_FacebookUrlCheck {

    public static void main(String[] args) {

        //    TC #2: Title and Url check
        //    1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        //    2. Go to https://www.facebook.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        //    3. Verify url contains facebook
        waitfor(2);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        verifyWordContains(currentUrl,"facebook");

        //    4. Verify title contains Facebook
        String currentTitle = driver.getTitle();
       verifyWordContains(currentTitle,"Facebook");


        //    5. Navigate to https://www.google.com

        driver.navigate().to("https://www.google.com");
        waitfor(2);
        //    6. Verify url contains google
        currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

      verifyWordContains(currentUrl,"google");
        //    7. Verify title contains Google

        currentTitle = driver.getTitle();

        verifyWordContains(currentTitle,"Google");
        //    8. Navigate back

        driver.navigate().back();

        waitfor(2);

        //    9. Verify url contains facebook

        currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        verifyWordContains(currentUrl,"facebook");


        //    10.Navigate forward
        driver.navigate().forward();
        waitfor(2);
        //    11.Verify url contains google

        currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

       verifyWordContains(currentUrl,"google");

        driver.close(); //only close the window without killing driver object
        driver.quit(); //killing the driver




    }

    private static void verifyWordContains(String sentence, String word) {
        if (sentence.contains(word)) {

            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
        }

    }

    private static void waitfor(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }
}
