package co.com.sofka.stepdefinitions.services;

import co.com.sofka.setup.services.MarvelConstants;
import co.com.sofka.setup.services.ServiceSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class SearchSingleComicStepDefinition extends ServiceSetup {
    @When("sends a GET request using id {int}")
    public void sendsAGETRequestUsingId(Integer comicId) {
        response = given()
                .pathParam("id", comicId)
                .queryParam("ts", 1)
                .queryParam("apikey", MarvelConstants.PUBLIC_API_KEY)
                .queryParam("hash", MarvelConstants.HASH)
                .when()
                .get(MarvelConstants.GET_SINGLE_COMIC_URL);

    }

    @Then("comic name should be {string}")
    public void comicNameShouldBe(String expectedComicTitle) {
        String actualComicTitle = (String) response.jsonPath().getList("data.results.title").get(0);
        assertThat("Comic name mismatch", actualComicTitle, equalTo(expectedComicTitle));
    }
}
