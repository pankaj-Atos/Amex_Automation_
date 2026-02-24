package stepDef;

import Factory.DriverFactory;
import PageObject.DashboardPage;
import PageObject.GitLoginPage;
import Util.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class DashboardSteps {
    GitLoginPage loginPage = new GitLoginPage(DriverFactory.getDriver());
    DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
    @Given("I am logged in")
    public void i_am_logged_in() {
        loginPage.goToLoginPage();
        loginPage.clickSignIn();
        loginPage.login();
    }

    @When("I click on the menu")
    public void i_open_the_menu() {
        dashboardPage.openMenu();
    }

    @And("I click on {string}")
    public void i_click_on_option(String option) {
        dashboardPage.clickPullRequests(option);
    }

    @Then("I should see the correct page title")
    public void i_should_see_the_correct_page_title() {
        System.out.println("Actual Title : " + dashboardPage.getTitle() );
        System.out.println("Expected Title : " + ConfigReader.getProperty("pageTitle") );
        Assert.assertEquals(dashboardPage.getTitle().trim(),ConfigReader.getProperty("pageTitle").trim());
        //assertTrue(dashboardPage.getTitle().contains(ConfigReader.getProperty("pageTitle")));
    }
}
