package com.davidbonelo.stepdefinitions;

import com.davidbonelo.pages.CustomizePage;
import com.davidbonelo.pages.FlightSummaryPage;
import com.davidbonelo.pages.FlightsResultPage;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.PassengersDataPage;
import com.davidbonelo.pages.PaymentPage;
import com.davidbonelo.pages.SeatsPage;
import com.davidbonelo.pages.components.ClassCard;
import com.davidbonelo.pages.components.FlightCard;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.davidbonelo.Utils.pickRandomItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class FlightSteps {
    private final WebSetup webSetup;
    HomePage homePage;
    FlightsResultPage flightsResultPage;
    SeatsPage seatsPage;
    FlightCard flight;
    CustomizePage customizePage;
    PaymentPage paymentPage;

    public FlightSteps(WebSetup webSetup) {
        this.webSetup = webSetup;
    }

    @Given("The user is in the home page")
    public void theUserIsInTheHomePage() {
        homePage = new HomePage(webSetup.driver);
    }

    @When("he selects one destination from the offers")
    public void heSelectsOneDestinationFromTheOffers() {
        List<String> destinationsOnOffer = homePage.getDestinationsOnOffer();
        String destination = pickRandomItem(destinationsOnOffer);
        flightsResultPage = homePage.openDestinationOffer(destination);
    }


    @Then("he should be able to see the flights available with their starting price")
    public void heShouldBeAbleToSeeTheFlightsAvailableWithTheirStartingPrice() {
        List<FlightCard> flights = flightsResultPage.getFlightCards();
        Assertions.assertFalse(flights.isEmpty());
        for (FlightCard flight : flights) {
            Assertions.assertNotNull(flight.getStartingPrice());
        }
    }

    @Given("The user is looking at the flights available for a destination")
    public void theUserIsLookingAtTheFlightsAvailableForADestination() {
        homePage = new HomePage(webSetup.driver);
        heSelectsOneDestinationFromTheOffers();
    }

    @When("he selects one flight to see its details")
    public void heSelectsOneFlightToSeeItsDetails() {
        List<FlightCard> flights = flightsResultPage.getFlightCards();
        flight = pickRandomItem(flights);
        flight.expandDetails();
    }

    @Then("he should be able to see its available classes and prices")
    public void heShouldBeAbleToSeeItsAvailableClassesAndPrices() {
        List<ClassCard> classes = flight.getClassesAvailable();
        Assertions.assertFalse(classes.isEmpty());
        for (ClassCard c : classes) {
            Assertions.assertNotNull(c.getPrice());
        }
        classes.forEach(ClassCard::getPrice);
    }

    @And("he sets the amount of passengers to {int}")
    public void heSetsTheAmountOfPassengersTo(int passengerAmount) {
        flightsResultPage.setPassengersAmount(passengerAmount);
    }

    @When("he selects one flight with any type of class")
    public void heSelectsOneFlightWithAnyTypeOfClass() {
        heSelectsOneFlightToSeeItsDetails();
//        ClassCard classCard = pickRandomItem(flight.getClassesAvailable());
//        classCard.select();
        flight.getClassesAvailable().get(0).select();
    }

    @And("he chooses the {int} seats from the available ones")
    public void heChoosesTheQuantitySeatsFromTheAvailableOnes(int quantity) {
        seatsPage = new FlightSummaryPage(webSetup.driver).navigateToSeatsPage();
        seatsPage.selectSeats(quantity);
        customizePage = seatsPage.confirmAndContinue();
    }

    @Then("he should see the payment summary for the tickets")
    public void heShouldSeeThePaymentSummaryForTheTickets() {
        Assertions.assertNotNull(customizePage.getFinalPrice());
    }

    @When("he configures a flight filling all the information")
    public void heConfiguresAFlightFillingAllTheInformation() {
        int passengers = 2;
        heSelectsOneDestinationFromTheOffers();
        heSetsTheAmountOfPassengersTo(passengers);
        heSelectsOneFlightWithAnyTypeOfClass();
        heChoosesTheQuantitySeatsFromTheAvailableOnes(passengers);
        PassengersDataPage passengersDataPage = customizePage.continueWithoutCustomizations();
        passengersDataPage.fillPassengersData();
        paymentPage = passengersDataPage.continueToPayment();
    }

    @And("he completes the payment process")
    public void heCompletesThePaymentProcess() {
        System.out.println(paymentPage.getTotalCost());
        assertThat(paymentPage.getTotalCost(), notNullValue());
    }

    @Then("he should get a confirmation of the purchase")
    public void heShouldGetAConfirmationOfThePurchase() {
    }
}
