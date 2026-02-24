package stepDef;

import Factory.DriverFactory;
import PageObject.DashboardPage;
import PageObject.GitLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class LoginSteps {

    GitLoginPage loginPage = new GitLoginPage(DriverFactory.getDriver());
    DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());

    @Given("I open the login page")
    public void i_open_the_login_page() {
        loginPage.goToLoginPage();
    }

    @And("I clicked on SignIn link")
    public void i_clicked_on_SignIn_link(){
        loginPage.clickSignIn();
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        assertTrue(dashboardPage.getTitle().contains("GitHub"));
    }
}
