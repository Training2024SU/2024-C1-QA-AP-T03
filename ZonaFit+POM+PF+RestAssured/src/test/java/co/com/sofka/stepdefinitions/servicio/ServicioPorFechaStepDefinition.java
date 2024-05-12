package co.com.sofka.stepdefinitions.servicio;

import co.com.sofka.setup.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ServicioPorFechaStepDefinition extends CommonFunctions {
    Response response;
    String cuerpoSolicitud;

    @Given("consulta por la fecha {int}")
    public void consultaPorLaFecha(Integer fecha) {
        cuerpoSolicitud = obtenerTodoPorFecha(fecha);
    }

    @When("envía la solicitud para obtener la informacion")
    public void envíaLaSolicitudParaObtenerLaInformacion() {
        response = given().get(cuerpoSolicitud);
    }

    @Then("deberia tener una respuesta con el codigo {int}")
    public void deberiaTenerUnaRespuestaConElCodigo(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println("codido de respuesta: "+statusCode);
    }

    @Then("la informacion recibida deberia concidir con la fecha {int}")
    public void laInformacionRecibidaDeberiaConcidirConLaFecha(Integer fecha) {
        response.then().assertThat().body("date", equalTo(fecha));
    }
}
