package com.davidbonelo.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static com.davidbonelo.ApiEndpoints.CURRENCIES_LIST_ENDPOINT;
import static com.davidbonelo.ApiEndpoints.PRICE_ENDPOINT;
import static com.davidbonelo.Utils.prepareCurrencyRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
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

    @When("The system requests the list of supported cryptocurrencies")
    public void theSystemRequestsTheListOfSupportedCryptocurrencies() {
        RequestSpecification request = prepareCurrencyRequest();
        response = request.when().get(CURRENCIES_LIST_ENDPOINT);
    }

    @Then("it should get a successful answer")
    public void itShouldGetASuccessfulAnswer() {
        response.then().statusCode(200);
    }

    @And("it should receive the complete list of currencies")
    public void itShouldReceiveTheCompleteListOfCurrencies() {
        String responseStr = response.asString();
        List<String> currencies = JsonPath.from(responseStr).getList("");
        assertThat(currencies, is(not(empty())));
    }
}
