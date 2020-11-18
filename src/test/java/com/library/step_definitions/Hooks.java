package com.library.step_definitions;

import com.library.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @After
    public void tearDown(Scenario scenario) {
        //close browser capture & take a screenshot if a Scenario Failed!!!
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
            System.out.println("Screenshot took from Scenario: " + scenario.getName() + ", Scenario Failed!!!");
        }

        Driver.closeDriver();
        System.out.println("End of test execution!!");
    }
}
