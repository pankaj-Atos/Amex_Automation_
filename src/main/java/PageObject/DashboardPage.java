package PageObject;
import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void openMenu() {
        click(menuButton);
    }

    public void clickPullRequests(String option) {
        WebElement menuOption = driver.findElement(By.xpath("//span[text()='" + option + "']/ancestor::a"));
        click(menuOption);
    }

    public String getTitle() {
        return driver.getTitle();
    }




    @FindBy(xpath = "//div[@data-testid='top-nav-left']//button[@data-component='IconButton']") // replace with actual CSS/XPath
    private WebElement menuButton;

    @FindBy(xpath = "//span[text()='Pull requests']/ancestor::a") // or use appropriate locator
    private WebElement pullRequestsLink;

    @FindBy(xpath = "//span[contains(text(),'Pull Requests')]")
    private WebElement prHome;
}
