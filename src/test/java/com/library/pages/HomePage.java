package com.library.pages;

import com.library.utils.BrowserUtility;
import com.library.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(partialLinkText = "Books")
    private WebElement bookModuleLink;

    public String getPageUrl(){

        return Driver.getDriver().getCurrentUrl();
    }

    public void clickOnBooksModule(){
        BrowserUtility.wait(2);
        bookModuleLink.click();
        System.out.println("Books link clicked!");
    }
}
