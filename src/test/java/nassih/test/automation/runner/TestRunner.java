package nassih.test.automation.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports",
                "usage",
        },
        glue={"stepDefinition"},
        monochrome = true
)
public class TestRunner {
}
