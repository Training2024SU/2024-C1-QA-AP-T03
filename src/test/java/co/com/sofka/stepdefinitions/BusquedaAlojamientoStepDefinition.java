package co.com.sofka.stepdefinitions;

import co.com.sofka.model.FormularioBuscarCommon;
import co.com.sofka.page.FormularioAlojamientoPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_HOME_DESPEGAR;
import static co.com.sofka.util.util.stringToDate;

public class BusquedaAlojamientoStepDefinition extends WebSetup {

    FormularioAlojamientoPage formAlojamientoPage;

    FormularioBuscarCommon form;

    @Given("el usuario está en la página de inicio de Despegar.com desde el navegador {string}")
    public void elUsuarioEstáEnLaPáginaDeInicioDeDespegarComDesdeElNavegador(String navegador) {
        try {
            generalSetUp(navegador,URL_HOME_DESPEGAR);
            formAlojamientoPage = new FormularioAlojamientoPage(driver);
            form = new FormularioBuscarCommon();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }

    @Given("el usuario selecciona el apartado de alojamiento")
    public void seleccionApartadoAlojamiento() {
        try {
            formAlojamientoPage.seleccionarAlojamiento();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }

    }
    @When("el usuario ingresa el origen {string} destino {string} del alojamiento, fecha de entrada {string} y de salida {string}")
    public void elUsuarioIngresaElOrigenDestinoDelAlojamientoFechaDeEntradaYDeSalida(String origen, String destino, String entrada, String salida) {
        try {
            form.setOrigen(origen);
            form.setDestino(destino);
            form.setFechaSalida(stringToDate(entrada));
            form.setFechaRegreso(stringToDate(salida));
            formAlojamientoPage.llenarFormularioBuscarAlojamineto(form);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }


    }
    @When("el usuario ingresa el número de habitaciones {int}")
    public void elUsuarioIngresaElNúmeroDePersonasYAgregaHabitacionesAdicionales(Integer int1) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario presiona el botón de buscar alojamiento")
    public void elUsuarioPresionaElBotónDeBuscarAlojamiento() {
        try {
            formAlojamientoPage.buscarAlojamiento();
            System.out.println("hecho");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("se deberían mostrar los resultados de alojamiento disponibles para las fechas y destinos especificados")
    public void seDeberíanMostrarLosResultadosDeAlojamientoDisponiblesParaLasFechasYDestinosEspecificados() throws InterruptedException {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            Thread.sleep(6500);
            quiteDriver();
        }
    }
}
