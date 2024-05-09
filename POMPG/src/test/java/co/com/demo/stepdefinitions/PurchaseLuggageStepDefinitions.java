package co.com.demo.stepdefinitions;

import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseLuggageStepDefinitions extends WebSetup {

    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private PurchaseLuggagePage purchaseLuggagePage;
    private SelectSeatPage selectSeatPage;

    @Given("I am initiating a flight booking and a luggage purchase {int} {string}")
    public void iAmInitiatingAFlightBookingAndALuggagePurchase(Integer tipoDriver, String url) {
        generalSetUp(tipoDriver, url);
        // Initialize all page objects needed for flight booking
        searchFlightPage = new SearchFlightPage(driver);
        selectFlightPage = new SelectFlightPage(driver);
        purchaseLuggagePage = new PurchaseLuggagePage(driver);
        selectSeatPage = new SelectSeatPage(driver);

    }

    @When("the user looking for a  flight from {string} to {string}")
    public void theUserLookingForAFlightFromTo(String origin, String destination) {
        searchFlightPage.searchOneFlight(origin,destination);
        switchToNewTab();
        }


    @When("choose a flight")
    public void chooseAFlight() {
        selectFlightPage.selectFlight();
    }
    @When("the user adds luggage to the booking")
    public void theUserAddsLuggageToTheBooking() {
        selectSeatPage.continueWithoutSeats();
        purchaseLuggagePage.addLuggage();

    }
    @Then("they should see the cost of the selected luggage")
    public void theyShouldSeeTheCostOfTheSelectedLuggage() {
    }
}
