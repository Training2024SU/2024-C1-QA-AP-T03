package co.com.demo.stepdefinitions;

import co.com.demo.page.SelectSeatPage;
import co.com.demo.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PurchaseSeatStepDefinitions extends WebSetup {
    private SelectSeatPage selectSeatPage;

    @When("the user selects seat options and chooses a seat")
    public void theUserSelectsSeatOptionsAndChoosesASeat() {
        selectSeatPage = new SelectSeatPage(driver);
        selectSeatPage.selectSeats();

    }
    @Then("they should see the selected seat reflected in the booking")
    public void theyShouldSeeTheSelectedSeatReflectedInTheBooking()
    {

    }
}
