package garcia.juan.stepdefinition;

import garcia.juan.page.MainPage;
import garcia.juan.setup.WebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class OrdenarVuelosSD extends WebSetUp {

    MainPage mainPage;

    @Given("el usuario realizo una busqueda de vuelos en la pagina de LATAM")
    public void el_usuario_realizo_una_busqueda_de_vuelos_en_la_pagina_de_latam() {
        generalSetUp(2);
        mainPage = new MainPage(driver);

    }
    @When("selecciona selecciona ordenar por el criterio {string}")
    public void selecciona_selecciona_ordenar_por_el_criterio(String string) {

    }
    @Then("el usuario debería ver la lista de vuelos ordenada por el criterio")
    public void el_usuario_debería_ver_la_lista_de_vuelos_ordenada_por_el_criterio() {

    }
}
