package co.com.sofka.stepdefinitions.servicio;

import co.com.sofka.setup.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ServicioPorEstadoStepDefinition extends CommonFunctions {
    Response response;
    String cuerpoSolicitud;

    @When("se pide al servicio la informacion por estado {string}")
    public void sePideAlServicioLaInformacionPorEstado(String estado) {
        cuerpoSolicitud = obtenerTodoPorEstado(estado);
        response = given().get(cuerpoSolicitud);
    }

    @Then("deberia recibir una respuesta con el codigo {int}")
    public void deberiaRecibirUnaRespuestaConElCodigo(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println("codido de respuesta: "+statusCode);
    }

    @Then("deberia recibir la informacion del estado {string}")
    public void deberiaRecibirLaInformacionDelEstado(String estado) {
        response.then().assertThat().body("state", equalTo(estado.toUpperCase()));
    }
}
