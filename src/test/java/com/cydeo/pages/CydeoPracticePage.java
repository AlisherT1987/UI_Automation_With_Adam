package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoPracticePage extends BasePage {

    public void clickOption(String optionName) {
        String locator = "//a[contains(.,'" + optionName + "')]";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.scrollToElement(element);
        BrowserUtils.clickElement(element);


    }


}
