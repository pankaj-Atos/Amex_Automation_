package hooks;

import Factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ApplicationHooks {

    @Before
    public void setup(Scenario scenario) {

        // Initialize new driver for each thread
        DriverFactory.initDriver();
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {

        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Step Screenshot");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}