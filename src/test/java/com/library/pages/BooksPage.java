package com.library.pages;

import com.library.utils.BrowserUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage{

    //This is the locator for Show Records Drop Down Menu
    @FindBy(xpath = "//select[@name='tbl_books_length']")
    private WebElement showsRecordDropDownMenu;

    @FindBy(id="book_categories")
    private WebElement categoriesDropDownMenu;

    public void selectShowsRecordDropDownMenu(String records){
        BrowserUtility.wait(1);
        BrowserUtility.selectByValue(showsRecordDropDownMenu,records);
    }

    public void selectCategoriesDropDownMenu(String categories){
        BrowserUtility.wait(1);
        BrowserUtility.selectByValue(categoriesDropDownMenu,categories);
    }

}
