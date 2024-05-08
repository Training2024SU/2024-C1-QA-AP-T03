package garcia.juan.stepdefinition;

import garcia.juan.page.MainPage;
import garcia.juan.setup.WebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BuscarVuelosSD extends WebSetUp {

    MainPage mainPage;

    @Given("el usuario esta en la pagina de inicio de Latam")
    public void el_usuario_esta_en_la_pagina_de_inicio_de_latam() {
        generalSetUp(2);
        mainPage = new MainPage(driver);
        try{
            mainPage.acceptCookies();
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.println(e.getMessage());
            Assertions.fail();
        }
//
    }
    @When("selecciona el origen {string}, destino {string}, fecha de salida {string} y fecha de regreso {string}")
    public void selecciona_el_origen_destino_fecha_de_salida_y_fecha_de_regreso(String origen, String destino, String string3, String string4) throws InterruptedException {

        try{
            mainPage.insertOrigenAndDestino(origen,destino);
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.println(e.getMessage());
            Assertions.fail();
        }

    }
    @When("hace click al boton de buscar")
    public void hace_click_al_boton_de_buscar() {

    }
    @Then("el usuario debería ver una lista de vuelos disponibles")
    public void el_usuario_debería_ver_una_lista_de_vuelos_disponibles() {
        quiteDriver();
    }

}
