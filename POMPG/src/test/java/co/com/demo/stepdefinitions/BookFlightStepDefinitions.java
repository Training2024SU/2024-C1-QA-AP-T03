package co.com.demo.stepdefinitions;

import co.com.demo.page.SearchFlightPage;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BookFlightStepDefinitions extends WebSetup {
    private SearchFlightPage searchFlightPage;


    @Given("I am initiating a flight booking process {int} {string}")
    public void iAmInitiatingAFlightBookingProcess(Integer tipoDriver, String url) {
        generalSetUp(tipoDriver, url);
        // Initialize the SearchFlightPage
        searchFlightPage = new SearchFlightPage(driver);
    }



    @When("the user searches for a one-way flight")
    public void theUserSearchesForAOneWayFlight() {
        searchFlightPage.searchOneFlight();

    }

    @When("selects a flight")
    public void selectsAFlight() {
        // Implement flight selection logic
    }

    @When("does not purchase seats or luggage")
    public void doesNotPurchaseSeatsOrLuggage() {
        // Implement logic for not purchasing seats or luggage
    }

    @When("adds passenger information and confirms it")
    public void addsPassengerInformationAndConfirmsIt() {
        // Implement logic for adding passenger information and confirmation
    }

    @Then("they should see a message with the details of the purchase")
    public void theyShouldSeeAMessageWithTheDetailsOfThePurchase() {
        // Implement verification logic for the purchase details message

    }
}
