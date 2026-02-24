package PageObject;

import Base.BasePage;
import Util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitLoginPage extends BasePage {

    // Constructor
    public GitLoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    public void login() {
        sendKeys(usernameField, ConfigReader.getProperty("username"));
        sendKeys(passwordField, ConfigReader.getProperty("password"));
        click(signInButton);
    }

    public void clickSignIn(){
        click(signInLink);
    }





    // Locators
    @FindBy(id = "login_field")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign in']")
    private WebElement signInButton;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;
}
