package com.library.pages;

import com.library.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    //This constructor will initialize the @FindBy annotation and our Driver
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getPageUrl(){
        return Driver.getDriver().getCurrentUrl();
    }

}
