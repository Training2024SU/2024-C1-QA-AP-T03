package co.com.sofkau.stepdefinitions;

import co.com.sofkau.page.FormularioFacturacionYEnvioPage;
import co.com.sofkau.page.OrdenCompletaPage;
import co.com.sofkau.page.ProductosPage;
import co.com.sofkau.setup.WebSetup;
import co.com.sofkau.util.ConstantesMensajeConfirmacion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;

public class ProcesoDeCompraStepDefinition extends WebSetup {
    FormularioFacturacionYEnvioPage formularioFacturacionYEnvioPage;
    OrdenCompletaPage ordenCompletaPage = new OrdenCompletaPage(driver);

    @When("llena el formulario de facturacion y envio")
    public void finalizaLaCompraYLlenaElFormularioDeFacturacionYEnvio(){
        formularioFacturacionYEnvioPage = new FormularioFacturacionYEnvioPage(driver);

        Faker faker = new Faker();
        String numeroDocumento =  faker.numerify("##########");;
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String direccion = faker.address().fullAddress();
        String numeroCelular = formularioFacturacionYEnvioPage.generarNumeroCelularColombiano(faker);

        formularioFacturacionYEnvioPage.llenarFormularioFacturacionYEnvio(numeroDocumento, nombre, apellido, email, direccion, numeroCelular);

        //Para confirmar facturación
        formularioFacturacionYEnvioPage.confirmarFacturacion();
    }
   @Then("la pagina de orden completa deberia mostrar el detalle del pedido y mensaje exitoso")
    public void debeMostrarDetalleDePedido(){
        Assertions.assertTrue(ordenCompletaPage.esElTituloDeDetalleVisible());
        Assertions.assertEquals(ordenCompletaPage.obtenerMensajeDeCompra(), ConstantesMensajeConfirmacion.MENSAJE_DE_ORDEN_EXITOSA);

        driver.quit();
    }
}
