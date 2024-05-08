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
            mainPage.quedarseColombia();
            mainPage.acceptCookies();
            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }
    @When("selecciona el origen {string}, destino {string}, fecha de salida {string} y fecha de regreso {string}")
    public void selecciona_el_origen_destino_fecha_de_salida_y_fecha_de_regreso(String origen, String destino, String fecha1, String fecha2) throws InterruptedException {

        try{
            mainPage.insertOrigenAndDestino(origen,destino);
            mainPage.buscarFecha(fecha1,fecha2);

        } catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }

    }
    @When("selecciona la opcion de buscar")
    public void selecciona_la_opcion_de_buscar() {
    mainPage.realizaBusqueda();
    }

    @Then("el usuario debería ver una lista de vuelos disponibles")
    public void el_usuario_debería_ver_una_lista_de_vuelos_disponibles() throws InterruptedException {
        Thread.sleep(3000);
        quiteDriver();
    }

}
