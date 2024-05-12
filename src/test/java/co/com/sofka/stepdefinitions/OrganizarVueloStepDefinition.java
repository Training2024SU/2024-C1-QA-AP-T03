package co.com.sofka.stepdefinitions;

import co.com.sofka.page.ResultadoVueloPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_RESULT_VUELO;
import static co.com.sofka.ConstantesEjecucion.ORIGEN;

public class OrganizarVueloStepDefinition extends WebSetup {

    ResultadoVueloPage resultadoVueloPage;
    @Given("que el usuario está en la página resultados de vuelo de Despegar.com desde el navegador {string}")
    public void queElUsuarioEstáEnLaPáginaResultadosDeVueloDeDespegarComDesdeElNavegador(String navegador) {
        try {
            generalSetUp(navegador,URL_RESULT_VUELO);
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
    public void seDeberíanMostrarLosResultadosDeVuelosDeA(String origen, String destino) {
        try {
            Assertions.assertEquals(origen,resultadoVueloPage.verificarOrigen());
            Assertions.assertEquals(destino,resultadoVueloPage.verificarDestino());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            quiteDriver();
        }
    }


}
