package co.com.demo.stepdefinitions;

import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseLuggageStepDefinitions extends WebSetup {

    @When("the user adds luggage to the booking")
    public void theUserAddsLuggageToTheBooking() {

    }
    @Then("they should see the cost of the selected luggage")
    public void theyShouldSeeTheCostOfTheSelectedLuggage() {
    quitDriver();
    }

}
