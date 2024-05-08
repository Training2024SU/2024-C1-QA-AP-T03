package co.com.demo.stepdefinitions;

import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangeFlightStepDefinitions extends WebSetup {

    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private PurchaseLuggagePage purchaseLuggagePage;
    private SelectSeatPage selectSeatPage;
    private PassengerInformationPage passengerInformationPage;

    @Given("I am initiating a flight booking process for a oneway {int} {string}")
    public void iAmInitiatingAFlightBookingProcessForAOneway(Integer tipoDriver, String url) {
        generalSetUp(tipoDriver, url);
        // Initialize all page objects needed for flight booking
        searchFlightPage = new SearchFlightPage(driver);
        selectFlightPage = new SelectFlightPage(driver);
        purchaseLuggagePage = new PurchaseLuggagePage(driver);
        selectSeatPage = new SelectSeatPage(driver);
        passengerInformationPage = new PassengerInformationPage(driver);
    }
    @When("the user searches for a one-way flight available")
    public void theUserSearchesForAOneWayFlightAvailable() {
        // Use existing searchFlightPage instance to perform search
        searchFlightPage.searchOneFlight();
        switchToNewTab();

    }
    @When("selects a new flight")
    public void selectsANewFlight() {
        // Use existing selectFlightPage instance to select a flight
        selectFlightPage.selectNewFlight();


    }
    @Then("they should see the updated flight details")
    public void theyShouldSeeTheUpdatedFlightDetails() {

    }

}
