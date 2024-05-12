package co.com.sofkau.stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;


public class DatosCovidApiZonaFitSD {

    private Response response;
    @When("el usuario realiza una solicitud GET para ver informacion sobre el Covid en todos los estados")
    public void realizaUnaSolicitudGetParaVerInformacionSobreElCovidEnTodosLosEstados() {
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .get("https://api.covidtracking.com/v2/states.json");

            System.out.println("Código de estado de la respuesta: " + response.getStatusCode());
            System.out.println("Cuerpo de la respuesta: " + response.getBody().asString());
            response.then().log().all(); // Imprime el cuerpo de la respuesta para debugging
        } catch (Exception e) {
            System.out.println("Error al realizar la solicitud GET: " + e.getMessage());
        }
    }

    @Then("el servicio deberia responder con un estado HTTP 200 OK y recibir todos los datos para cada estado")
    public void elServicioDeberiaReponderConEstadoHttp200() {
        try {
            // Verificar que la solicitud obtenga una respuesta exitosa (código de estado HTTP 200 OK)
            Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "El servicio no respondió con el código de estado 200 OK");
        } catch (Exception e) {
            System.out.println("Error al verificar la respuesta del servicio: " + e.getMessage());
        }
    }
}