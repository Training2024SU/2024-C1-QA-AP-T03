package co.com.sofka.stepdefinitions;

import co.com.sofka.model.FormularioBuscarCommon;
import co.com.sofka.page.FormVueloPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_HOME_DESPEGAR;
import static co.com.sofka.util.util.stringToDate;

public class BusquedaVueloStepDefinition extends WebSetup {

    FormVueloPage formVueloPage;

    FormularioBuscarCommon form;

    @Given("que el usuario está en la página de inicio de Despegar.com desde el navegador {string}")
    public void queElUsuarioEstáEnLaPáginaDeInicioDeDespegarComDesdeElNavegador(String navegador) {
        try {
            generalSetUp(navegador,URL_HOME_DESPEGAR);
            formVueloPage= new FormVueloPage(driver);
            form = new FormularioBuscarCommon();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }


    @When("el usuario ingresa el origen {string}, destino {string} del vuelo, fecha de ida {string} y de vuelta {string}")
    public void elUsuarioIngresaElOrigenDestinoDelVueloFechaDeIdaYDeVuelta(String origen, String destino, String ida, String vuelta) {
        try {
            form.setOrigen(origen);
            form.setDestino(destino);
            form.setFechaSalida(stringToDate(ida));
            form.setFechaRegreso(stringToDate(vuelta));
            formVueloPage.llenarFormularioBuscarViaje(form);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("selecciona el numero de personas mayores de edad {int}")
    public void seleccionaElNumeroDePersonasMayoresDeEdad(Integer numPer) {
        try {
            form.setNumPersonas(numPer);
            formVueloPage.ingresarNumPersonas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario presiona el botón de buscar vuelos")
    public void elUsuarioPresionaElBotónDeBuscarVuelos() {
        try {
            formVueloPage.buscarVuelo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("se debería mostrar los resultados de vuelos disponibles para las fechas y destinos especificados")
    public void seDeberíaMostrarLosResultadosDeVuelosDisponiblesParaLasFechasYDestinosEspecificados() {
        try {


        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("los resultados deberían incluir opciones de vuelo de ida y vuelta")
    public void losResultadosDeberíanIncluirOpcionesDeVueloDeIdaYVuelta() {
        try {


        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            quiteDriver();
        }
    }

}
