package co.com.sofka.stepdefinitions.web;


import co.com.sofka.page.PageFactoryDespegarFly;
import co.com.sofka.setup.web.WebBrowser;
import co.com.sofka.setup.web.WebPage;
import co.com.sofka.setup.web.WebSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FlyReservationStepDefinition extends WebSetup {
    private PageFactoryDespegarFly pageFactoryFly;

    @Given("the User is on despegar.com using {string}")
    public void theUserIsOnDespegarComUsing(String webBrowser) {
        generalSetup(WebBrowser.valueOf(webBrowser), WebPage.DESPEGAR);
    }

    @When("navigates to fly page")
    public void navigatesToFlyPage() {
        pageFactoryFly = new PageFactoryDespegarFly(driver);
    }

    @When("selects a flight from {string} to {string}")
    public void selectsAFlightFromTo(String fromDestiny, String toDestiny) {
        pageFactoryFly.selectSource(fromDestiny);
        pageFactoryFly.selectTarget(toDestiny);

    }

    @When("departs on {int}-{int}-{int} returning on {int}-{int}-{int} for {int} passengers")
    public void departsOnReturningOnForPassengers(Integer fromYear, Integer fromMonth,
                                                  Integer fromDay, Integer toYear,
                                                  Integer toMonth, Integer toDay, Integer passengers) throws InterruptedException {

        pageFactoryFly.selectFromDate(fromYear, fromMonth, fromDay);
        pageFactoryFly.selectToDate(toYear, toMonth, toDay);
        pageFactoryFly.confirmDate();
        pageFactoryFly.selectPassengers(passengers);
        pageFactoryFly.confirmDetails();

    }

    @When("confirms flight details")
    public void confirmsFlightDetails() {
        // Can not continue
    }

    @Then("should receive a confirmation message")
    public void shouldReceiveAConfirmationMessage() {
        // Can not continue
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}
