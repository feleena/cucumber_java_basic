package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^I am on the locators page$")
    public void iAmOnLocatorsPage() {
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void iShouldSeeLocatorsPageHeaders() throws Throwable {
        assertEquals("Heading 1", driver.findElement(By.id("heading_1")).getText());
        assertEquals("Heading 2 text", driver.findElement(By.id("heading_2")).getText());

    }

    @And("^Buttons in Locators page are clickable$")
    public void iShouldlocatorPageAreClickable() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());
    }

    @Then("^I see error: ([^\"]*)$")
    public void iSeeAgeError(String anything) throws Throwable {
        assertEquals(anything, driver.findElement(By.id("error")).getText());
    }

    @Then("I am not navigated to age message page")
    public void iAmNotInAgeMessagePage() throws Throwable {
        assertFalse(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age_2.html"));
    }


    @Given("I am on Feedback page")
    public void iAmOnFeedbackPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @And("I enter age in feedback: \"([^\"]*)\"$")
    public void iEnterAgeInFeedback(String age) throws Throwable {
        driver.findElement(By.id("fb_age")).clear();
        driver.findElement(By.id("fb_age")).sendKeys(age);
    }

    @When("^I enter name in feedback: \"([^\"]*)\"$")
    public void iEnterNameInFeedback(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @When("^I click send feedback$")
    public void iClickSendFeedback() throws Throwable {
        driver.findElement(By.className("w3-btn-block")).click();
    }

    @Then("^I can see name \"([^\"]*)\" in feedback check$")
    public void iCanSeeNameInFeedbackCheck(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.id("name")).getText());
    }

    @Then("^I can see age \"([^\"]*)\" in feedback check$")
    public void iCanSeeAgeInFeedbackCheck(String age) throws Throwable {
        assertEquals(age, driver.findElement(By.id("age")).getText());
    }


    @Given("I am on enter a number page")
    public void iAmOnEnterANumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("I enter a number: \"([^\"]*)\"$")
    public void iEnterANumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("I click submit number")
    public void iClickSubmitNumber() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("I can see message \"([^\"]*)\"$")
    public void iCanSeeMessage(String message) {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("I see success message: \"([^\"]*)\"$")
    public void iSeeSuccessMessage(String message) {
        Alert newAlert = driver.switchTo().alert();
        assertEquals(message, newAlert.getText());
        newAlert.accept();

    }


    @When("^I select Feedback languages:")
    public void iSelectFeedbackLanguages(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^I can see languages \"([^\"]*)\" in feedback check$")
    public void iCanSeeLanguagesInFeedbackCheck(String lang) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(lang, driver.findElement(By.id("language")).getText());

    }

    @When("^I enter values to the Feedback form:")
    public void iEnterValuesToTheFeedbackForm(DataTable inputTable) throws Throwable {
        for (Map<String, String> feedbackInput : inputTable.asMaps(String.class, String.class)) {
        if (feedbackInput.containsKey("name")) {
            driver.findElement(By.id("fb_name")).sendKeys(feedbackInput.get("name"));
        }
            driver.findElement(By.id("fb_age")).sendKeys(feedbackInput.get("age"));
            driver.findElement(By.cssSelector("[value='" + feedbackInput.get("genre") + "']")).click();
        }
    }

    @Then("^I can see genre \"([^\"]*)\" in feedback check$")
    public void iCanSeeGenreInFeedbackCheck(String genre) throws Throwable {
        assertEquals(genre,driver.findElement(By.id("gender")).getText());
    }
}
