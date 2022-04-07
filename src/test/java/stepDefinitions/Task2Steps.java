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

public class Task2Steps {
    private WebDriver driver;

    public Task2Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on people page$")
    public void iAmOnPeoplePage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @When("^I click add person$")
    public void iClickAddPerson() {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I enter input in enter a new person page$")
    public void iEnterInputInEnterANewPersonPage(Map<String, String> personInput) throws Throwable {
        if (personInput.containsKey("name")){
            driver.findElement(By.id("name")).sendKeys(personInput.get("name"));
        }
        if (personInput.containsKey("job")){
            driver.findElement(By.id("job")).sendKeys(personInput.get("job"));
        }
        if (personInput.containsKey("dateOfBirth")){
            driver.findElement(By.id("dob")).sendKeys(personInput.get("dateOfBirth"));
        }
        if (personInput.containsKey("lang")){
            driver.findElement(By.cssSelector("[value='" + personInput.get("lang") + "']")).click();
        }


    }

    @And("^I click Submit Button$")
    public void iClickSubmitButton() {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^I can see person detail \"([^\"]*)\" in peoples page$")
    public void iCanSeePersonDetailInPeoplesPage(String detail) throws Throwable {
       assertEquals(detail,driver.findElement(By.id("person3")).getText().replaceAll("\\r\\n|\\r|\\n", " "));

    }

    @When("^I click edit third  person$")
    public void iClickEditThirdPerson() {
        driver.findElement(By.xpath("//*[@id=\"person2\"]/span[2]/i")).click();
    }


    @And("^I click Edit Button$")
    public void iClickEditButton() {
        driver.findElement(By.id("modal_button")).click();
    }


    @And("^I changed name: \"([^\"]*)\"$")
    public void iChangedName(String arg0) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(arg0);

    }

    @Then("^I can see new person detail in peoples page: \"([^\"]*)\"$")
    public void iCanSeeNewPersonDetailInPeoplesPage(String arg0) throws Throwable {
        assertEquals(arg0,driver.findElement(By.id("person2")).getText().replaceAll("\\r\\n|\\r|\\n", " "));

    }

    @When("^I click remove third person$")
    public void iClickRemoveThirdPerson() {
        driver.findElement(By.xpath("//*[@id=\"person2\"]/span[1]")).click();
    }

    @Then("^person is removed$")
    public void personIsRemoved() throws InterruptedException {
        assertEquals(5,driver.findElements(By.tagName("li")).size());
    }

    @And("^I click Reset button$")
    public void iClickResetButton() {
        driver.findElement(By.xpath("//*[text()='Reset List']")).click();
    }

    @Then("^the page has reset$")
    public void thePageHasReset() throws InterruptedException {
        assertEquals(6,driver.findElements(By.tagName("li")).size());
    }

    @And("^I click clear all fields$")
    public void iClickClearAllFields() {
        driver.findElement(By.xpath("//*[text()='Clear all fields']")).click();
    }

    @Then("^Form is reset$")
    public void formIsReset() {
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("job")).getText());
        assertEquals("",driver.findElement(By.id("dob")).getText());


    }
}
