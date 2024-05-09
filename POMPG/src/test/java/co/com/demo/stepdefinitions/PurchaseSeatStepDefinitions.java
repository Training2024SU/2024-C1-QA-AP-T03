package co.com.demo.stepdefinitions;

import co.com.demo.page.*;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseSeatStepDefinitions extends WebSetup {

    private SearchFlightPage searchFlightPage;
    private SelectFlightPage selectFlightPage;
    private PurchaseLuggagePage purchaseLuggagePage;
    private SelectSeatPage selectSeatPage;
    private PassengerInformationPage passengerInformationPage;

    @Given("I am initiating a flight booking and a seat purchase {int} {string}")
    public void iAmInitiatingAFlightBookingAndASeatPurchase(Integer tipoDriver, String url) {
        generalSetUp(tipoDriver, url);
        // Initialize all page objects needed for flight booking
        searchFlightPage = new SearchFlightPage(driver);
        selectFlightPage = new SelectFlightPage(driver);
        purchaseLuggagePage = new PurchaseLuggagePage(driver);
        selectSeatPage = new SelectSeatPage(driver);
        passengerInformationPage = new PassengerInformationPage(driver);

    }
    @When("the user searches for a flight")
    public void theUserSearchesForAFlight() {
        searchFlightPage.searchOneFlight();
        switchToNewTab();

    }
    @When("selects it")
    public void selectsIt() {
        selectFlightPage.selectFlight();
    }
    @When("the user selects seat options and chooses a seat")
    public void theUserSelectsSeatOptionsAndChoosesASeat() {
        selectSeatPage.selectSeats();

    }
    @Then("they should see the selected seat reflected in the booking")
    public void theyShouldSeeTheSelectedSeatReflectedInTheBooking() {

    }
}
