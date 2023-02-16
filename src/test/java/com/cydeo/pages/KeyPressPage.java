package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressPage extends BasePage{

    @FindBy(xpath = "//body")
    public WebElement body;

    @FindBy(id = "result")
    public WebElement result;

    public void clickKey(Keys key){
        BrowserUtils.waitForVisibilityOf(homeLink);
        body.sendKeys(key);
    }
}
