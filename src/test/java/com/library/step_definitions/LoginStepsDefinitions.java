package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utils.BrowserUtility;
import com.library.utils.ConfigurationReader;
import com.library.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepsDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user located on login page")
    public void user_located_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user type credentials")
    public void user_type_credentials() {
        loginPage.login();
    }

    @Then("user should be able to land on dashboard page")
    public void user_should_be_able_to_land_on_dashboard_page() {
        BrowserUtility.wait(1);
        String actual = homePage.getPageUrl();
        String expecting = "dashboard";
        Assert.assertTrue("URL NOT contains dashboard, validation FAILS!!!",actual.contains(expecting));
        //Driver.closeDriver();
    }

}
