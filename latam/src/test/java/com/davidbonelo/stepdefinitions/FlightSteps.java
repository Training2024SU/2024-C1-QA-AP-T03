package com.davidbonelo.stepdefinitions;

import com.davidbonelo.pages.FlightsResultPage;
import com.davidbonelo.pages.HomePage;
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
        String destination = (String) pickRandomItem(destinationsOnOffer);
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
}
