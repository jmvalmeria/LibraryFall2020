package com.library.pages;

import com.library.utils.BrowserUtility;
import com.library.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BooksPage extends BasePage{

    //This is the locator for Show Records Drop Down Menu
    @FindBy(xpath = "//select[@name='tbl_books_length']")
    private WebElement showsRecordDropDownMenu;

    @FindBy(id="book_categories")
    private WebElement categoriesDropDownMenu;

    public void selectShowsRecordDropDownMenu(String records){
        BrowserUtility.wait(1);
        BrowserUtility.selectValue(showsRecordDropDownMenu,records);
    }

    public void selectCategoriesDropDownMenu(String categories){
        BrowserUtility.wait(1);
        BrowserUtility.selectValue(categoriesDropDownMenu,categories);
    }

}
