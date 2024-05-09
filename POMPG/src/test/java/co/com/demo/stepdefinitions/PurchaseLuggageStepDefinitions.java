package co.com.demo.stepdefinitions;

import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class PurchaseLuggageStepDefinitions extends WebSetup {

    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private PurchaseLuggagePage purchaseLuggagePage;
    private SelectSeatPage selectSeatPage;

    @Given("I am initiating a flight booking and a luggage purchase {int} {string}")
    public void iAmInitiatingAFlightBookingAndALuggagePurchase(Integer tipoDriver, String url) {
        try {
            generalSetUp(tipoDriver, url);
            // Initialize all page objects needed for flight booking
            searchFlightPage = new SearchFlightPage(driver);
            selectFlightPage = new SelectFlightPage(driver);
            purchaseLuggagePage = new PurchaseLuggagePage(driver);
            selectSeatPage = new SelectSeatPage(driver);
        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to set up the driver: " + e.getMessage());
        }
    }

    @When("the user looking for a flight from {string} to {string}")
    public void theUserLookingForAFlightFromTo(String origin, String destination) {
        try {
            searchFlightPage.searchOneFlight(origin, destination);
            switchToNewTab();
        } catch (Exception e) {
            System.out.println("Error during flight search: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed during flight search: " + e.getMessage());
        }
    }

    @When("choose a flight")
    public void chooseAFlight() {
        try {
            selectFlightPage.selectFlight();
        } catch (Exception e) {
            System.out.println("Error selecting flight: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to select flight: " + e.getMessage());
        }
    }

    @When("the user adds luggage to the booking")
    public void theUserAddsLuggageToTheBooking() {
        try {
            selectSeatPage.continueWithoutSeats();
            purchaseLuggagePage.addLuggage();
        } catch (Exception e) {
            System.out.println("Error adding luggage: " + e.getMessage());
            quitDriver();
            Assertions.fail("Failed to add luggage: " + e.getMessage());
        }
    }

    @Then("they should see the cost of the selected luggage")
    public void theyShouldSeeTheCostOfTheSelectedLuggage() {
        // Implementación de la lógica de verificación del costo del equipaje seleccionado
        // Puedes agregar código de aserción o validación aquí para verificar el costo del equipaje seleccionado
    }
}
