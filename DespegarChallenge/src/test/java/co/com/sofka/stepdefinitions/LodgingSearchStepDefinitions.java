package co.com.sofka.stepdefinitions;

import co.com.sofka.pages.despegarpages.HomePage;
import co.com.sofka.pages.despegarpages.LodgingPage;
import co.com.sofka.setup.WebSetUp;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LodgingSearchStepDefinitions extends WebSetUp {
    LodgingPage lodgingPage;
    HomePage homePage;

    @When("goes to lodging page to perform the search city {string} from {int} {int} to {int} {int} and adults {int}")
    public void goesToLodgingPageToPerformTheSearchCityFromToAndAdults(String city, Integer day, Integer month, Integer day2, Integer month2, Integer people) {
        try {
            homePage = new HomePage(driver);
            lodgingPage = new LodgingPage(driver);
            homePage.goToLodgingPage();
            lodgingPage.searchLodging(city);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

    @When("selects the first lodging option")
    public void selectsTheFirstLodgingOption() {
    }

}
