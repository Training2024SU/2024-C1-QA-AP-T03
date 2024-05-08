package co.com.sofka.stepdefinitions.services;

import co.com.sofka.setup.services.MarvelConstants;
import co.com.sofka.setup.services.ServiceSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;


import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.setup.services.MarvelConstants.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SearchAllHeroesStepDefinition extends ServiceSetup {
    List<String> allHeroNames = new ArrayList<>();
    @Given("the user is connected to the Marvel Developer API")
    public void theUserIsConnectedToTheMarvelDeveloperAPI() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("sends a GET request to retrieve all heroes")
    public void sendsAGETRequestToRetrieveAllHeroes() {
        int limit = 20;
        int maxPages = 5;
        for (int page = 0; page < maxPages; page++) {
            int offset = page * limit;
            response = given()
                    .queryParam("ts", 1)
                    .queryParam("apikey", MarvelConstants.PUBLIC_API_KEY)
                    .queryParam("hash", MarvelConstants.HASH)
                    .queryParam("offset", offset)
                    .queryParam("limit", limit)
                    .when()
                    .get(MarvelConstants.GET_ALL_CHARACTERS_URL);
            List<String> heroNames = response.jsonPath().getList("data.results.name");
            allHeroNames.addAll(heroNames);
        }
    }


    @Then("response should contain information about all heroes including")
    public void responseShouldContainInformationAboutAllHeroesIncluding(List<String> expectedHeroNames) {
        assertThat(allHeroNames, not(empty()));

        for (String expectedName : expectedHeroNames) {
            assertThat(allHeroNames, hasItem(expectedName));
        }
    }


    @Then("should receive a response of {int}")
    public void shouldReceiveAResponseOf(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}