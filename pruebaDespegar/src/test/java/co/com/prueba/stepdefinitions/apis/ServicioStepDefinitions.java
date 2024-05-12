package co.com.prueba.stepdefinitions.apis;

import co.com.prueba.model.listaseries.DTOListaSeries;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static co.com.prueba.util.ConstantStepDefinitions.API_URL_MARVEL;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServicioStepDefinitions {
    private Response response;
    @Dado("que el servicio GET en la pagina developer.marvel.com/ está en línea y accesible")
    public void queElServicioGETEnLaPaginaDeveloperMarvelComEstáEnLíneaYAccesible() {
        RestAssured.baseURI = API_URL_MARVEL;
    }
    @Cuando("realiza una solicitud GET atravez del endpoint")
    public void realizaUnaSolicitudGETAtravezDelEndpoint() {
        response = given()
                .param("apikey","b8d13567f4fc00f6eda4b6fab2c18450")
                .log().all()
                .param("hash","cc8de0d2f3c0890c504495f6a90b8390")
                .param("ts","1")
                .get("/series");
    }

    @Entonces("deberia mostrar un código de estado HTTP {int}")
    public void deberiaMostrarUnCódigoDeEstadoHTTP(Integer int1) {
        assertEquals(response.getStatusCode(),200);
        Gson gson = new Gson();
        DTOListaSeries dtoListaSeries = gson.fromJson(response.getBody().asString(), DTOListaSeries.class);
        assertTrue((dtoListaSeries.getData().getResults().size() !=0));
    }
}
