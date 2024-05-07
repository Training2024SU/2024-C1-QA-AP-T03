package co.com.sofka.stepdefinitions;



import co.com.sofka.page.PageFactoryFly;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebBrowser;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;


public class FlyReservationStepDefinition extends WebSetup {
    private PageFactoryFly pageFactoryFly;

    @Given("the User is on despegar.com using {string}")
    public void theUserIsOnDespegarComUsing(String webBrowser) {
        generalSetup(WebBrowser.valueOf(webBrowser));
    }
    @When("navigates to fly page")
    public void navigatesToFlyPage() {
        PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
        pageFactoryFly = new PageFactoryFly(driver);
        //pageFactoryMain.navigateToFlies();

    }
    @When("selects a flight from {string} to {string}")
    public void selectsAFlightFromTo(String fromDestiny, String toDestiny){
        pageFactoryFly.selectSource(fromDestiny);
        pageFactoryFly.selectTarget(toDestiny);

    }
    @When("departs on {int}-{int}-{int} returning on {int}-{int}-{int} for {int} passengers")
    public void departsOnReturningOnForPassengers(Integer fromYear, Integer fromMonth,
                                                  Integer fromDay, Integer toYear,
                                                  Integer toMonth, Integer toDay, Integer passengers) {

        pageFactoryFly.selectFromDate(fromYear, fromMonth, fromDay);
        pageFactoryFly.selectToDate(toYear, toMonth, toDay);
        pageFactoryFly.confirmDate();
        pageFactoryFly.selectPassengers(passengers);

    }
    @When("confirms the chosen flight details")
    public void confirmsTheChosenFlightDetails() {

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
