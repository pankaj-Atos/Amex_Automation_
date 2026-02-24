package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRunner {
    @CucumberOptions(
            features = "src/test/resources/featureFile",
            glue = {"stepDef"},
            plugin = {"pretty", "html:target/cucumber-reports.html"},
            monochrome = true
    )
    public class TestNGRunner extends AbstractTestNGCucumberTests {
    }
}
