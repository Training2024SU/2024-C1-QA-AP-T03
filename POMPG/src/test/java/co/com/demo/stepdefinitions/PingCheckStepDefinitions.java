package co.com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PingCheckStepDefinitions {

    private Response response;

    @Given("the CoinGecko API is online")
    public void theCoinGeckoAPIIsOnline() {
        // No se requiere implementación específica para este paso
    }

    @When("a GET request is made to {string}")
    public void aGETRequestIsMadeTo(String endpoint) {
        // Realizar la solicitud GET a la URL especificada
        response = RestAssured.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        // Verificar el código de estado de la respuesta
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain {string} with value {string}")
    public void theResponseShouldContain(String key, String expectedValue) {
        // Verificar si la respuesta contiene el campo específico con el valor esperado
        String responseBody = response.getBody().asString();
        assertTrue("Response should contain key '" + key + "' with value '" + expectedValue + "'",
                responseBody.contains("\"" + key + "\":\"" + expectedValue + "\""));
    }
}
