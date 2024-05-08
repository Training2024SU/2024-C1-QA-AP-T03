package co.com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ServicioStatesStepDefinition {
    Faker faker = new Faker();
    String randomStateCode;
    private Response response;

    @Given("el usuario ingresa un codigo de estado especifico")
    public void ingresarCodigoEstadoEspecifico() {
        // Generar un código de estado aleatorio en minúscula utilizando Java Faker
        randomStateCode = faker.address().stateAbbr().toLowerCase();
        System.out.println("Código de estado: " + randomStateCode);
    }

    @When("realiza una solicitud GET para ver informacion sobre el Covid en dicho estado")
    public void realizarSolicitudGET() {
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .get("https://api.covidtracking.com/v2/states/" + randomStateCode + "/daily.json");

            System.out.println("Código de estado de la respuesta: " + response.getStatusCode());
            System.out.println("Cuerpo de la respuesta: " + response.getBody().asString());
            response.then().log().all(); // Imprime el cuerpo de la respuesta para debugging
        } catch (Exception e) {
            System.out.println("Error al realizar la solicitud GET: " + e.getMessage());
        }
    }

    @Then("el servicio deberia responder con un estado HTTP 200 OK y recibir todos los datos historicos para dicha zona")
    public void verificarRespuestaServicio() {
        try {
            // Verificar que la solicitud obtenga una respuesta exitosa (código de estado HTTP 200 OK)
            Assertions.assertEquals(200, response.getStatusCode(), "El servicio no respondió con el código de estado 200 OK");

            // Verificar que la respuesta contenga datos históricos
            Assertions.assertTrue(response.getBody().asString().contains("meta"));
            Assertions.assertTrue(response.getBody().asString().contains("data"));
        } catch (Exception e) {
            System.out.println("Error al verificar la respuesta del servicio: " + e.getMessage());
        }
    }
}
