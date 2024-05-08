package co.com.sofka.stepdefinitions.web;


import co.com.sofka.page.PageFactoryFly;
import co.com.sofka.page.PageFactoryFlyOptions;
import co.com.sofka.setup.web.WebBrowser;
import co.com.sofka.setup.web.WebSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FlyReservationStepDefinition extends WebSetup {
    private PageFactoryFly pageFactoryFly;

    @Given("the User is on despegar.com using {string}")
    public void theUserIsOnDespegarComUsing(String webBrowser) {
        generalSetup(WebBrowser.valueOf(webBrowser));
    }

    @When("navigates to fly page")
    public void navigatesToFlyPage() {
        pageFactoryFly = new PageFactoryFly(driver);
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

    @When("confirms the chosen flight details")
    public void confirmsTheChosenFlightDetails() throws InterruptedException {
//        PageFactoryFlyOptions pageFactoryFlyOptions = new PageFactoryFlyOptions(driver);
//        pageFactoryFlyOptions.confirmCookies();
//        pageFactoryFlyOptions.selectRandomAirline();
    }

    @When("confirms their personal information")
    public void confirmsTheirPersonalInformation() {

    }

    @Then("should receive a confirmation message")
    public void shouldReceiveAConfirmationMessage() {

    }

    @After
    public void tearDown() {
        quiteDrive();
    }
}
