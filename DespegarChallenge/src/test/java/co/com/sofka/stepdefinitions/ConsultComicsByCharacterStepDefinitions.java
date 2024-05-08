package co.com.sofka.stepdefinitions;

import co.com.sofka.servicefunctions.ServiceFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Calendar;

import static co.com.sofka.Constants.PRIVATE_KEY;
import static co.com.sofka.Constants.PUBLIC_KEY;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class ConsultComicsByCharacterStepDefinitions extends ServiceFunctions {
    Response response;
    String publicKey;
    String privateKey;

    @When("make a GET request to the endpoint {string} with parameter {string} valid character ID {int}")
    public void makeAGETRequestToTheEndpointWithParameterValidCharacterID(String endpoint, String parameter, Integer characterId) {
        publicKey = PUBLIC_KEY;
        privateKey = PRIVATE_KEY;
        long timeStamp = Calendar.getInstance().getTimeInMillis();
        String hash = generateMD5Hash(timeStamp, publicKey, privateKey);
        response = given().pathParam(parameter, characterId).queryParam("apikey", publicKey)
                .queryParam("ts", timeStamp).queryParam("hash", hash).when().get(endpoint);

    }

    @Then("should get a status code {int}")
    public void shouldGetAStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(response.getBody().asString());
    }

    @Then("the answer contains at least a comic associated with the character")
    public void theAnswerContainsAtLeastAComicAssociatedWithTheCharacter() {
        response.then().assertThat().body("data.results.title", hasItem(notNullValue()));
    }
}
