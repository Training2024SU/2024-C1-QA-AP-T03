package co.com.demo.stepdefinitions;

import co.com.demo.model.Passenger;
import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import co.com.demo.util.util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookFlightStepDefinitions extends WebSetup {
    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private PurchaseLuggagePage purchaseLuggagePage;
    private SelectSeatPage selectSeatPage;
    private PassengerInformationPage passengerInformationPage;

    @Given("I am initiating a flight booking process {int} {string}")
    public void iAmInitiatingAFlightBookingProcess(Integer tipoDriver, String url) {
        generalSetUp(tipoDriver, url);
        // Initialize all page objects needed for flight booking
        searchFlightPage = new SearchFlightPage(driver);
        selectFlightPage = new SelectFlightPage(driver);
        purchaseLuggagePage = new PurchaseLuggagePage(driver);
        selectSeatPage = new SelectSeatPage(driver);
        passengerInformationPage = new PassengerInformationPage(driver);
    }

    @When("the user searches for a one-way flight from {string} to {string}")
    public void theUserSearchesForAOneWayFlightFromTo(String origin, String destination) {
        searchFlightPage.searchOneFlight(origin,destination);
        switchToNewTab();
    }


    @When("selects a flight")
    public void selectsAFlight() {
        // Use existing selectFlightPage instance to select a flight
        selectFlightPage.selectFlight();
    }

    @When("does not purchase seats or luggage")
    public void doesNotPurchaseSeatsOrLuggage() {
        // Implement logic for not purchasing seats or luggage using existing pages
        selectSeatPage.continueWithoutSeats();
        purchaseLuggagePage.continueWithoutLuggage();
    }

    @When("adds passenger information and confirms it")
    public void addsPassengerInformationAndConfirmsIt() {
        Passenger user = util.createPassenger();
        passengerInformationPage.enterPassengerInformation(user);

        Passenger secondUser = util.createadditionalPassenger();
        passengerInformationPage.enterSecondPassengerInformation(secondUser);

    }

    @Then("they should see a message with the details of the purchase")
    public void theyShouldSeeAMessageWithTheDetailsOfThePurchase() {
        // Implement verification logic for the purchase details message
        // You can add assertion/validation code here to verify the purchase details message
    }
}
