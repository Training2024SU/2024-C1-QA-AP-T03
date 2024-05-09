package co.com.sofka.stepdefinitions;

import co.com.sofka.pages.FlightsPage;
import co.com.sofka.pages.HomePage;
import co.com.sofka.setup.WebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FlightsSearchStepDefinitions extends WebSetUp {
    HomePage homePage;
    FlightsPage flightsPage;

    @Given("the user is in the Despegar homepage in the {int}")
    public void theUserIsInTheDespegarHomepageInThe(Integer driverType) {
        try {
            generalSetUp(driverType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

    @When("performs a flight search with origin {string} destination {string} from {int} {string} to {int} {string} and cantidad de personas {int}")
    public void performsAFlightSearchWithOriginDestinationFromToAndCantidadDePersonas(String origin, String destination, Integer day, String month, Integer day2, String month2, Integer amountPeople) {
        try {
            homePage = new HomePage(driver);
            homePage.searchFlight(origin, destination, month, day, month2, day2, amountPeople);
            Thread.sleep(8000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

    @When("selects the first flight option")
    public void selectsTheFirstFlightOption() {
        try {
            flightsPage = new FlightsPage(driver);
            homePage.changeTab();
            flightsPage.selectFlight();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

    @Then("should see results of available flights")
    public void shouldSeeResultsOfAvailableFlights() {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            //quiteDriver();
        }
    }

}
