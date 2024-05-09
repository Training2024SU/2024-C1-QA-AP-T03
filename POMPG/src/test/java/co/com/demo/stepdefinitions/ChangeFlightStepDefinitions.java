package co.com.demo.stepdefinitions;

import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static co.com.demo.stepdefinitions.ConstantExecution.NEW_TICKET;

public class ChangeFlightStepDefinitions extends WebSetup {

    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private PurchaseConfirmationPage purchaseConfirmationPage;

    @Given("I am initiating a flight booking process for a oneway {int} {string}")
    public void iAmInitiatingAFlightBookingProcessForAOneway(Integer tipoDriver, String url) {
        try {
            generalSetUp(tipoDriver, url);
            // Initialize all page objects needed for flight booking
            searchFlightPage = new SearchFlightPage(driver);
            selectFlightPage = new SelectFlightPage(driver);
            purchaseConfirmationPage = new PurchaseConfirmationPage(driver);
        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to set up the driver: " + e.getMessage());
        }
    }

    @When("the user searches for a one-way flight available from {string} to {string}")
    public void theUserSearchesForAOneWayFlightAvailableFromTo(String origin, String destination) {
        try {
            searchFlightPage.searchOneFlight(origin, destination);
            switchToNewTab();
        } catch (Exception e) {
            System.out.println("Error during flight search: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during flight search: " + e.getMessage());
        }
    }

    @When("selects a new flight")
    public void selectsANewFlight() {
        try {
            // Use existing selectFlightPage instance to select a flight
            selectFlightPage.selectNewFlight();
        } catch (Exception e) {
            System.out.println("Error during flight selection: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during flight selection: " + e.getMessage());
        }
    }

    @Then("they should see the updated flight details")
    public void theyShouldSeeTheUpdatedFlightDetails() {
        try {
            String actualMessage = purchaseConfirmationPage.getNewTickerText();
            Assert.assertEquals(NEW_TICKET, actualMessage);
        } catch (Exception e) {
            System.out.println("Error during message verification: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to verify registration message: " + e.getMessage());
        } finally {
            quitDriver();
        }
    }
}
