package com.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html", //It will generate the report
                "rerun:target/rerun.txt", //It will generate a txt with the failed scenarios
                "json:target/cucumber.json" //It will generate a JSON report in target folder
        },
        features = "src/test/resources/features", //It looks for the feature in the path
        glue = "com/library/step_definitions", //It looks for the steps to perform the test
        tags = "@AC4",
        dryRun = false
)

public class CucumberRunner2 {
}
