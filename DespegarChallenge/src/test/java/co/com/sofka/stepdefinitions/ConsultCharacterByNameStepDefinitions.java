package co.com.sofka.stepdefinitions;

import co.com.sofka.servicefunctions.ServiceFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import static co.com.sofka.Constants.PRIVATE_KEY;
import static co.com.sofka.Constants.PUBLIC_KEY;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;

public class ConsultCharacterByNameStepDefinitions extends ServiceFunctions {
    Response response;
    String publicKey;
    String privateKey;

    @Given("the user has access to marvel API {string}")
    public void theUserHasAccessToMarvelAPI(String url) {
        RestAssured.baseURI = url;
    }

    @When("makes a GET request to the endpoint {string} with parameter {string} equal to {string}")
    public void makesAGETRequestToTheEndpointWithParameterEqualTo(String endpoint, String parameter, String characterName) throws NoSuchAlgorithmException {
        publicKey = PUBLIC_KEY;
        privateKey = PRIVATE_KEY;
        long timeStamp = Calendar.getInstance().getTimeInMillis();
        String hash = generateMD5Hash(timeStamp, publicKey, privateKey);
        response = given().queryParam(parameter, characterName).queryParam("apikey", publicKey)
                .queryParam("ts", timeStamp).queryParam("hash", hash).when().get(endpoint);

    }

    @Then("should have a status code {int}")
    public void shouldHaveAStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(response.getBody().asString());
    }

    @Then("the answer contains at least one character with a name {string}")
    public void theAnswerContainsAtLeastOneCharacterWithAName(String characterName) {
        response.then().assertThat().body("data.results.name", hasItem(containsString(characterName)));
    }
}
