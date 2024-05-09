package com.davidbonelo.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.davidbonelo.ApiEndpoints.PRICE_ENDPOINT;
import static com.davidbonelo.Utils.prepareCurrencyRequest;
import static org.hamcrest.Matchers.notNullValue;

public class CurrencySteps {
    private Response response;

    @When("The system asks for the current price of {string} in {string}")
    public void theSystemAsksForTheCurrentPriceOfIn(String crypto, String currency) {
        RequestSpecification request = prepareCurrencyRequest();
        response =
                request.when().get(PRICE_ENDPOINT + "?ids=" + crypto + "&vs_currencies=" + currency);
    }

    @Then("it should get a successful answer with the market price of {string} in {string}")
    public void itShouldGetASuccessfulAnswerWithTheMarketPriceOfIn(String crypto, String currency) {
        response.then()
                .statusCode(200)
                .body(crypto + "." + currency, notNullValue(Double.class));
    }
}
