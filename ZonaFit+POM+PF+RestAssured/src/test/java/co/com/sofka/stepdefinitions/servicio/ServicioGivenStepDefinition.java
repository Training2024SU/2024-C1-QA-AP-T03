package co.com.sofka.stepdefinitions.servicio;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static co.com.sofka.constant.Urls.URL_SERVICIO_PATH;
import static co.com.sofka.constant.Urls.URL_SERVICIO_ZONAFIT;

public class ServicioGivenStepDefinition {
    @Given("un usuario administrador en la página web de ZonaFit")
    public void unUsuarioAdministradorEnLaPáginaWebDeZonaFit() {
        RestAssured.baseURI = URL_SERVICIO_ZONAFIT;
        RestAssured.basePath = URL_SERVICIO_PATH;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
