package co.com.demo.stepdefinitions;

import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangeFlightStepDefintions extends WebSetup {

    @When("the user changes the selected flight to a new one")
    public void theUserChangesTheSelectedFlightToANewOne() {

    }
    @Then("they should see the updated flight details")
    public void theyShouldSeeTheUpdatedFlightDetails() {
    quitDriver();
    }

}
