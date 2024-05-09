package co.com.demo.stepdefinitions;

import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.demo.stepdefinitions.ConstantExecution.SEATS_TOTAL;

public class PurchaseSeatStepDefinitions extends WebSetup {

    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private SelectSeatPage selectSeatPage;
    private PurchaseLuggagePage purchaseLuggagePage;
    private PurchaseConfirmationPage purchaseConfirmationPage;

    @Given("I am initiating a flight booking and a seat purchase {int} {string}")
    public void iAmInitiatingAFlightBookingAndASeatPurchase(Integer tipoDriver, String url) {
        try {
            generalSetUp(tipoDriver, url);
            // Initialize all page objects needed for flight booking
            searchFlightPage = new SearchFlightPage(driver);
            selectFlightPage = new SelectFlightPage(driver);
            selectSeatPage = new SelectSeatPage(driver);
            purchaseLuggagePage = new PurchaseLuggagePage(driver);
            purchaseConfirmationPage = new PurchaseConfirmationPage(driver);
        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to set up the driver: " + e.getMessage());
        }
    }

    @When("the user searches for a flight from {string} to {string}")
    public void theUserSearchesForAFlightFromTo(String origin, String destination) {
        try {
            searchFlightPage.searchOneFlight(origin, destination);
            switchToNewTab();
        } catch (Exception e) {
            System.out.println("Error during flight search: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during flight search: " + e.getMessage());
        }
    }

    @When("selects it")
    public void selectsIt() {
        try {
            selectFlightPage.selectFlight();
        } catch (Exception e) {
            System.out.println("Error selecting flight: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to select flight: " + e.getMessage());
        }
    }

    @When("the user selects seat options and chooses a seat")
    public void theUserSelectsSeatOptionsAndChoosesASeat() {
        try {
            selectSeatPage.selectSeats();
            purchaseLuggagePage.continueWithoutLuggage();
        } catch (Exception e) {
            System.out.println("Error selecting seats: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to select seats: " + e.getMessage());
        }
    }


    @Then("they should see the selected seat reflected in the booking")
    public void theyShouldSeeTheSelectedSeatReflectedInTheBooking() {
        try {
            String actualMessage = purchaseConfirmationPage.getSeatsTotalText();
            if (actualMessage.contains(SEATS_TOTAL)) {
                System.out.println("Error: The selected seat cost is zero.");
                Assertions.fail("The selected seat cost is zero.");
            }
        } catch (Exception e) {
            System.out.println("Error during seat cost verification: " + e.getMessage());
            Assertions.fail("Error during seat cost verification: " + e.getMessage());
        } finally {
            quitDriver();
        }
    }

}
