package co.com.sofka.stepdefinitions;

import co.com.sofka.pages.despegarpages.HomePage;
import co.com.sofka.pages.despegarpages.LodgingPage;
import co.com.sofka.setup.WebSetUp;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SearchCarStepDefinitions extends WebSetUp {
    HomePage homePage;
    @When("goes to cars page to perform the search city {string} from {int} {int} to {int} {int} and adults {int}")
    public void goesToCarsPageToPerformTheSearchCityFromToAndAdults(String string, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
        try {
            homePage = new HomePage(driver);
            homePage.goToCarsPage();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }
    @When("selects the first option")
    public void selectsTheFirstOption() {

    }

}
