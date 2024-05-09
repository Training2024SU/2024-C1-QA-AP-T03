package co.com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;

public class PingCheckStepDefinitions {

    private Response response;

    @Given("the CoinGecko API is online")
    public void theCoinGeckoAPIIsOnline() {
        // No implementation needed
    }

    @When("a GET request is made to {string}")
    public void aGETRequestIsMadeTo(String endpoint) {
        try {
            response = RestAssured.get(endpoint);
        } catch (Exception e) {
            System.out.println("Error making GET request: " + e.getMessage());
            Assertions.fail("Failed to make GET request: " + e.getMessage());
        }
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        try {
            assertEquals(expectedStatusCode, response.getStatusCode());
        } catch (Exception e) {
            System.out.println("Error verifying response status code: " + e.getMessage());
            Assertions.fail("Failed to verify response status code: " + e.getMessage());
        }
    }

    @Then("the response should contain {string} with value {string}")
    public void theResponseShouldContain(String key, String expectedValue) {
        try {
            String responseBody = response.getBody().asString();
            assertTrue("Response should contain key '" + key + "' with value '" + expectedValue + "'",
                    responseBody.contains("\"" + key + "\":\"" + expectedValue + "\""));
        } catch (Exception e) {
            System.out.println("Error verifying response content: " + e.getMessage());
            Assertions.fail("Failed to verify response content: " + e.getMessage());
        }
    }
}
