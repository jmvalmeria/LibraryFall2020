package com.library.pages;

import com.library.pages.BasePage;
import com.library.utils.ConfigurationReader;
import com.library.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "inputEmail")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);

        System.out.println("Library logged in successfully!");
    }

    public void login(String usernameVale, String passwordValue){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        username.sendKeys(usernameVale);
        password.sendKeys(passwordValue, Keys.ENTER);
        System.out.println("Library logged in successfully!");
    }

    //Esto es una prueba desde IntellIj

}
