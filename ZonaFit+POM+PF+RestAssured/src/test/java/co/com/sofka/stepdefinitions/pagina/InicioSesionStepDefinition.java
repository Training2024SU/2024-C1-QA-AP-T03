package co.com.sofka.stepdefinitions.pagina;

import co.com.sofka.model.FormularioModel;
import co.com.sofka.page.FormularioPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.constant.ResultadosEsperados.*;
import static co.com.sofka.util.Util.crearUsuario;

public class InicioSesionStepDefinition extends WebSetup {
    public static FormularioPage formularioPage;
    FormularioModel formularioModel;

    @Given("que el usuario se encuentra en la pagina de inicio de ZonaFit")
    public void queElUsuarioSeEncuentraEnLaPaginaDeInicioDeZonaFit() {
        definirPagina();
    }

    @Given("con el navegador {int}")
    public void conElNavegador(Integer navegador) {
        try {
            setUpWebdriverUrl(navegador);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("ingresa su informacion correctamente de email {string} y contraseña {string}")
    public void ingresaSuInformacionCorrectamenteDeEmailYContraseña(String email, String contrasena) {
        try {
            formularioModel = crearUsuario();
            formularioPage = new FormularioPage(driver, formularioModel);
            formularioPage.llenarFormulario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("confirma la acción")
    public void confirmaLaAcción() {
        try {
            formularioPage.confirmarInicioSesion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("deberia observar que se inicio sesión")
    public void deberiaObservarQueSeInicioSesión() {
        try {
            Assertions.assertEquals(MENSAJE_MI_CUENTA, formularioPage.obtenerMensajeLoguedo());
            System.out.println("Aserciones");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("selecciona los productos {int} {int} {int}")
    public void seleccionaLosProductos(int prod1, int prod2, int prod3) {
        try {
            formularioPage.seleccionMenos200();
            formularioPage.seteccionarProductos(prod1);
            //formularioPage.seteccionarProductos(prod2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @Then("deberia verse los productos en el carrito")
    public void deberiaVerseLosProductosEnElCarrito() {
        try {
            formularioPage.finalizarCompra();
            System.out.println("ver productos carrito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Given("que el usuario va a la página de carrito")
    public void queElUsuarioVaALaPáginaDeCarrito() {
        try {
            formularioPage.irAlCarrito();
            System.out.println("abrir pagina Carrito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("confirma la compra")
    public void confirmaLaCompra() {
        try {
            formularioPage.irAComprar();
            System.out.println("Confirmar compra");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("deberia aparecer la forma de pago")
    public void deberiaAparecerLaFormaDePago() {
        try {
            formularioPage.llenarFacturacion();
            System.out.println("Llenar formulario de pago");
            Assertions.assertEquals(MENSAJE_FACTURACION, formularioPage.obtenerMensajeFacturacion());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        } finally {
            //quitDriver();
        }
    }
}
