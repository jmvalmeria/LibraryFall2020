package com.library.pages;

import com.library.utils.BrowserUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BooksPage extends BasePage{

    //This is the locator for Show Records Drop Down Menu
    @FindBy(xpath = "//select[@name='tbl_books_length']")
    private WebElement showsRecordDropDownMenu;

    public void selectShowsRecordDropDownMenu(String records){
        BrowserUtility.wait(2);
        Select select = new Select(showsRecordDropDownMenu);
        select.selectByValue(records);
    }

    public String showsRecordValue(String records){
        BrowserUtility.wait(2);
        return showsRecordDropDownMenu.getAttribute("value");
    }

}
