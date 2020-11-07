package com.library.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtility {

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //This method allow us to handle a DropDown Menu passing a WebElement and a String for value
    public static void selectValue(WebElement webElement, String value){
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }
    
}
