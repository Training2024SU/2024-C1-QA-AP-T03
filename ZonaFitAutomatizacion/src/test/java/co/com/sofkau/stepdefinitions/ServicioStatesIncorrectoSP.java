package co.com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

public class ServicioStatesIncorrectoSP {
    Faker faker = new Faker();
    String randomStateCode;
    private Response response;

    @Given ("el usuario no ingresa un codigo de estado requerido")
    public void elUsuarioNoIngresCodigoDeEstadoRequerido(){
        try {
            //Generar un código de estado aleatorio en minúscula utilizando Java Faker
            randomStateCode = faker.address().stateAbbr().toLowerCase();
            System.out.println("Código de estado: " + "");
        }catch (Exception e){
            System.out.println("Error al realizar la solicitud GET: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail();
        }

    }
    @Then ("el servicio deberia responder con un estado HTTP 404 y no recibiria los datos historicos para dicha zona")
    public void elServicioDeberiaResponderConUnEstadoDeError(){
        try {
            // Verificar que la solicitud obtenga una respuesta exitosa (código de estado HTTP 404 OK)
            Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode(), "El servicio no respondió con el código de estado 404 OK");
        } catch (Exception e) {
            System.out.println("Error al verificar la respuesta del servicio: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
