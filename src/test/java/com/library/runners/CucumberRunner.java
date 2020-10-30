package com.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html", //It will generate the report
        features = "src/test/resources/features", //It looks for the feature in the path
        glue = "com/library/step_definitions", //It looks for the steps to perform the test
        tags = "@AC5",
        dryRun = false
)

public class CucumberRunner {
}
