package co.com.sofka.stepdefinitions;

import co.com.sofka.model.FormPersonaModel;
import co.com.sofka.page.AgregarCarritoPage;
import co.com.sofka.page.DatosUsuarioPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_HOME_EXITO;
import static co.com.sofka.util.util.generarFormularioPersonaAleatorio;

public class CompraExitoStepDefinition extends WebSetup {

    AgregarCarritoPage carritoPage;

    DatosUsuarioPage datosUsuarioPage;

    FormPersonaModel personaModel;

    @Given("que el usuario está en la página de inicio del Éxito desde el navegador {string}")
    public void queElUsuarioEstáEnLaPáginaDeInicioDelÉxito(String navegador) {
        try {
            generalSetUp(navegador,URL_HOME_EXITO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario elige un producto en promoción y lo agrega al carrito")
    public void elUsuarioEligeUnProductoEnPromociónYLoAgregaAlCarrito() {
        try {
            personaModel = generarFormularioPersonaAleatorio();
            carritoPage = new AgregarCarritoPage(driver,personaModel.getCorreo());
            carritoPage.elegirProducto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario indica la cantidad del producto y llena formulario de informacion personal")
    public void elUsuarioIndicaLaCantidadDelProductoYLlenaFormularioDeInformacionPersonal() {
        try {
            carritoPage.elegirCantidadProductos();
            datosUsuarioPage = new DatosUsuarioPage(driver,personaModel);
            datosUsuarioPage.llenarFormularioInfoPersona();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario ingresa la información de envio")
    public void ingresaInformacionEnvio() {
        try {
            datosUsuarioPage.llenarFormularioRecogerPersona();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("completa la información de pago")
    public void completaLaInformaciónDePago() {
        try {
            Assertions.assertEquals(personaModel.getCiudad(),datosUsuarioPage.getTextEnvio());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("se debería mostrar un mensaje de confirmación de la compra")
    public void seDeberíaMostrarUnMensajeDeConfirmaciónDeLaCompra() {
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
