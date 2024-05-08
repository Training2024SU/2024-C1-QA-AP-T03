package com.davidbonelo.stepdefinitions;

import com.davidbonelo.pages.FlightsResultPage;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.components.ClassCard;
import com.davidbonelo.pages.components.FlightCard;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.davidbonelo.Utils.pickRandomItem;

public class FlightSteps {
    private final WebSetup webSetup;
    HomePage homePage;
    FlightsResultPage flightsResultPage;
    FlightCard flight;

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
}
