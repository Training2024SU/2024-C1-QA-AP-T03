package co.com.demo.stepdefinitions;

import co.com.demo.model.Passenger;
import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import co.com.demo.util.util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BookFlightStepDefinitions extends WebSetup {
    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private PurchaseLuggagePage purchaseLuggagePage;
    private SelectSeatPage selectSeatPage;
    private PassengerInformationPage passengerInformationPage;

    @Given("I am initiating a flight booking process {int} {string}")
    public void iAmInitiatingAFlightBookingProcess(Integer tipoDriver, String url) {
        try{
            generalSetUp(tipoDriver, url);
            // Initialize all page objects needed for flight booking
            searchFlightPage = new SearchFlightPage(driver);
            selectFlightPage = new SelectFlightPage(driver);
            purchaseLuggagePage = new PurchaseLuggagePage(driver);
            selectSeatPage = new SelectSeatPage(driver);
            passengerInformationPage = new PassengerInformationPage(driver);
        }catch (Exception e){
            System.out.println("Error during setup" + e.getMessage());
            quitDriver();
            Assertions.fail("Failder to sep up the driver" + e.getMessage());
        }
    }

    @When("the user searches for a one-way flight from {string} to {string}")
    public void theUserSearchesForAOneWayFlightFromTo(String origin, String destination) {
        try {
            searchFlightPage.searchOneFlight(origin, destination);
            switchToNewTab();
        } catch (Exception e) {
            System.out.println("Error during search: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during flight search: " + e.getMessage());
        }
    }

    @When("selects a flight")
    public void selectsAFlight() {
        try {
            selectFlightPage.selectFlight();
        } catch (Exception e) {
            System.out.println("Error during flight selection: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during flight selection: " + e.getMessage());
        }
    }

    @When("does not purchase seats or luggage")
    public void doesNotPurchaseSeatsOrLuggage() {
        try {
            selectSeatPage.continueWithoutSeats();
            purchaseLuggagePage.continueWithoutLuggage();
        } catch (Exception e) {
            System.out.println("Error during seat/luggage selection: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during seat/luggage selection: " + e.getMessage());
        }
    }

    @When("adds passenger information and confirms it")
    public void addsPassengerInformationAndConfirmsIt() {
        try {
            Passenger user = util.createPassenger();
            passengerInformationPage.enterPassengerInformation(user);
            Passenger secondUser = util.createadditionalPassenger();
            passengerInformationPage.enterSecondPassengerInformation(secondUser);
        } catch (Exception e) {
            System.out.println("Error during passenger information entry: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during passenger information entry: " + e.getMessage());
        }
    }


    @Then("they should see a message with the details of the purchase")
    public void theyShouldSeeAMessageWithTheDetailsOfThePurchase() {

    }

}
