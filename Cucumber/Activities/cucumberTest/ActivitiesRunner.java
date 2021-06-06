package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.junit.*;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
	
    features = "Features",	
    glue = {"stepDefinitions"},	
    tags = "@activity1_1, @activity1_2, @activity1_3, @activity2_4, @activity2_5",
    plugin = { "pretty", "html:target/cucumber-reports/reports", "json:target/cucumber-reports/reports/report.json" },
    monochrome = true
)

public class ActivitiesRunner {

}
