package com.library.step_definitions;

import com.library.pages.BooksPage;
import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utils.BrowserUtility;
import com.library.utils.ConfigurationReader;
import com.library.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BooksModule {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();

    @Given("user logged in successfully")
    public void user_logged_in_successfully() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username,password);
    }

    @Given("user located at Books module")
    public void user_located_at_books_module() {
        homePage.clickOnBooksModule();
    }

    @When("click on Show records dropDown menu and select {string}")
    public void click_on_show_records_drop_down_menu_and_select(String string) {
        booksPage.selectShowsRecordDropDownMenu(string);
        System.out.println("Number: " + string + " of books is selected!");
        BrowserUtility.wait(1);
    }
    @Then("User should be able to see {string} book information on the books grid")
    public void user_should_be_able_to_see_book_information_on_the_books_grid(String string) {
        List<WebElement> displayedRecords = Driver.getDriver().findElements(By.xpath("//table[@id='tbl_books']//tr/td[2]"));
        BrowserUtility.wait(1);
        String actualResult = ""+displayedRecords.size();

        System.out.println("Select: " + string + " records , displayed: " + actualResult + " books");

        Assert.assertEquals("Number of Records are not equal, Verification FAILED!!!",actualResult,string);
        Driver.closeDriver();
    }

    @When("User click on Books Categories dropDown menu and select {string}")
    public void user_click_on_books_categories_drop_down_menu_and_select(String categories) {
        booksPage.selectCategoriesDropDownMenu(categories);
        BrowserUtility.wait(1);
        System.out.println(categories + " is selected in the drop down menu!");
    }

    @Then("User should be able to see {string} books on the books grid")
    public void user_should_be_able_to_see_books_on_the_books_grid(String categories) {
        List<WebElement> displayedCategories = Driver.getDriver().findElements(By.xpath("//table[@id='tbl_books']//tr/td[5]"));

        for (WebElement each : displayedCategories){
            String displayElement = each.getText();
            if (!displayElement.contains(categories)){
                System.out.println(displayElement + "is different than " + categories);
            }
        }

        String actualCategory = displayedCategories.get(0).getText();

        Assert.assertEquals("The Displayed Category is not displayed, Verification Failed!!!",actualCategory,categories);
        System.out.println("Drama books are displayed!");
        Driver.closeDriver();
    }

}
