package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePage{


    public void hoverOverUser(int userNum){
        String locator="(//img)["+userNum+"]";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));

        //I need to have one method for hover
        BrowserUtils.hover(element);
    }
    public String getUserName(int userNum){
        String locayor="(//h5)["+userNum+"]";
       return Driver.getDriver().findElement(By.xpath(locayor)).getText();
    }

}
