package co.com.sofka.stepdefinitions;

import co.com.sofka.page.ResultadoVueloPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_REGISTRO_FORM;
import static co.com.sofka.setup.UrlLibrary.URL_RESULT_VUELO;

public class OrganizarVueloStepDefinition extends WebSetup {

    ResultadoVueloPage resultadoVueloPage;
    @Given("que el usuario está en la página resultados de vuelo de Despegar.com desde el navegador {string}")
    public void queElUsuarioEstáEnLaPáginaResultadosDeVueloDeDespegarComDesdeElNavegador(String string) {
        try {
            generalSetUp(2,URL_RESULT_VUELO);
            Thread.sleep(10000);
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario visualiza vuelos de ida y vuelta de {string} a {string}")
    public void elUsuarioBuscaVuelosDeIdaYVueltaDeA(String origen, String destino) {
        try {
            resultadoVueloPage = new ResultadoVueloPage(driver,origen,destino);
            Assertions.assertTrue(resultadoVueloPage.verificarOrigenDestino());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("organiza los vuelos por menor duracion")
    public void losOrganizaPorMenorDuracion() {
        try {
            resultadoVueloPage.ordenarVueloPorDuracion();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("se deberían mostrar los resultados de vuelos de {string} a {string}")
    public void seDeberíanMostrarLosResultadosDeVuelosDeA(String string, String string2) {
        try {

        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("se debería mostrar los resultados disponibles organizados por menor duración")
    public void seDeberíaMostrarLosResultadosDisponiblesOrganizadosPorMenorDuración() throws InterruptedException {
        try {

        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            Thread.sleep(10000);
        }
    }

}
