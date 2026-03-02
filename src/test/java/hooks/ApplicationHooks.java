package hooks;

import Factory.DriverFactory;
import com.aventstack.extentreports.*;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ApplicationHooks {


    @Before
    public void setup(Scenario scenario) {

        DriverFactory.getDriver();
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {

        System.out.println("Attaching screenshot for step: " + scenario.getName());

        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Step Screenshot");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}