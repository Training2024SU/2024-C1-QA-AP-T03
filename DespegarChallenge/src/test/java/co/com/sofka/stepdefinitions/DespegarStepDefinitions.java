package co.com.sofka.stepdefinitions;

import co.com.sofka.setup.WebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DespegarStepDefinitions extends WebSetUp {
    @Given("the user is in the Despegar homepage")
    public void theUserIsInTheDespegarHomepage() {
    }
    @When("performs a flight search with origin {string} destination {string} from {int} {string} to {int} {string} and cantidad de personas {int}")
    public void performsAFlightSearchWithOriginDestinationFromToAndCantidadDePersonas(String string, String string2, Integer int1, String string3, Integer int2, String string4, Integer int3) {
    }
    @Then("should see results of available flighs")
    public void shouldSeeResultsOfAvailableFlighs() {
    }
}
