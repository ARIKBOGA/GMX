package task_1.com.gmx.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import task_1.com.gmx.pages.HomePage;
import task_1.com.gmx.pages.LoginPage;
import task_1.com.gmx.pages.MyAccountPage;
import task_1.com.gmx.pages.PersonalDataPage;
import task_1.com.gmx.utilities.BrowserUtils;
import task_1.com.gmx.utilities.ConfigurationReader;
import task_1.com.gmx.utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GmxStepDefs {
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private MyAccountPage myAccountPage = new MyAccountPage();
    private PersonalDataPage personalDataPage = new PersonalDataPage();

    @Given("User goes to home page")
    public void userGoesToHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User clicks to login button to be able to open login window")
    public void userClicksToLoginButtonToAbeleToOpenLoginWindow() {
        loginPage.getLoginLink().click();
    }

    @When("User enters credentials")
    public void userEntersCredentials() {
        loginPage.getEmailInput().sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.getPasswordInput().sendKeys(ConfigurationReader.getProperty("password"));
    }

    @And("User clicks to login-submit button")
    public void userClicksToLoginSubmitButton() {
        loginPage.getLoginButton().click();
    }

    @Then("User should be able to logged in successfully")
    public void userShouldBeAbleToLoggedInSuccessfully() {
        assertTrue(homePage.getLogoutLink().isDisplayed());
    }

    @Given("User clicks to My Account link and goes to page")
    public void userClicksToMyAccountLinkAndGoesToPage() {
        Driver.getDriver().switchTo().frame("thirdPartyFrame_home");
        homePage.getMyAccountLink().click();
        Driver.getDriver().switchTo().parentFrame();
    }

    @And("User clicks to Personal Data link and goes to page")
    public void userClicksToPersonalDataLinkAndGoesToPage() {
        BrowserUtils.waitForVisibility(By.xpath("//iframe[@id='thirdPartyFrame_ciss']"), 30);
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='thirdPartyFrame_ciss']")));
        myAccountPage.getPersonalDataLink().click();
    }

    @And("User clicks to Profile link and goes to page")
    public void userClicksToProfileLinkAndGoesToPage() {
        personalDataPage.getProfileInfoLink().click();
    }

    @And("User changes his own name and lastname to {string} & {string}")
    public void userChangesHisOwnNameAndLastnameTo(String firstName, String lastname) {
        personalDataPage.getFirstnameInput().clear();
        personalDataPage.getLastnameInput().clear();
        personalDataPage.getFirstnameInput().sendKeys(firstName);
        personalDataPage.getLastnameInput().sendKeys(lastname);
        personalDataPage.getPasswordInput().sendKeys(ConfigurationReader.getProperty("password"));
        personalDataPage.getSaveChangesButton().click();
    }

    @When("User goes back to My Account page")
    public void userGoesBackToMyAccountPage() {
        personalDataPage.getMyAccountPageLink().click();
    }

    @Then("User should see the new name and last name as {string}")
    public void userShouldSeeTheNewNameAndLastNameAs(String fullname) {
        String actual = myAccountPage.getFullName().getText();
        assertEquals(fullname, actual);
    }
}