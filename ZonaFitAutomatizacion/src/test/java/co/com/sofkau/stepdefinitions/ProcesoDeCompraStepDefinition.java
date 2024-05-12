package co.com.sofkau.stepdefinitions;

import co.com.sofkau.model.FormularioFacturacionYEnvioModel;
import co.com.sofkau.page.FormularioFacturacionYEnvioPage;
import co.com.sofkau.page.OrdenCompletaPage;
import co.com.sofkau.page.ProductosPage;
import co.com.sofkau.setup.WebSetup;
import co.com.sofkau.util.constant.ConstantesMensajeConfirmacion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.Util.crearUsuario;

public class ProcesoDeCompraStepDefinition extends WebSetup {
    FormularioFacturacionYEnvioPage formularioFacturacionYEnvioPage;
    OrdenCompletaPage ordenCompletaPage = new OrdenCompletaPage(driver);
    ProductosPage productosPage;
    FormularioFacturacionYEnvioModel formularioFacturacionYEnvioModel;

    @Given ("ingresa a la pagina de productos")
    public void ingresaALaPaginaDeProductos(){
        try {
            productosPage =  new ProductosPage(driver);
            productosPage.navegarAProductos();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }
    }
    @When ("ingresa los {int} primeros productos disponibles al carrito, confirmando los productos seleccionados")
    public void ingresaLosPrimerosProductosDisponibles(int cantidadDeProdutos){
        try {
            productosPage.seleccionarProductos(cantidadDeProdutos);
            productosPage.abrirModalCarrito();
            ProductosPage.confirmarProductos();
        }catch (Exception e){
            System.out.println("Error al ingresar productos al carrito: " + e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }

    }
    @When("llena el formulario de facturacion y envio")
    public void finalizaLaCompraYLlenaElFormularioDeFacturacionYEnvio(){
        try {
        formularioFacturacionYEnvioModel = crearUsuario();

        formularioFacturacionYEnvioPage = new FormularioFacturacionYEnvioPage(driver, formularioFacturacionYEnvioModel);
        formularioFacturacionYEnvioPage.llenarFormularioFacturacionYEnvio();

        //Para confirmar facturación
        formularioFacturacionYEnvioPage.confirmarFacturacion();
    }catch (Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();
        quiteDriver();
        Assertions.fail();
        }
    }
   @Then("la pagina de orden completa deberia mostrar el detalle del pedido y mensaje exitoso")
    public void debeMostrarDetalleDePedido(){
        try {
            Assertions.assertTrue(ordenCompletaPage.esElTituloDeDetalleVisible());
            Assertions.assertEquals(ordenCompletaPage.obtenerMensajeDeCompra(), ConstantesMensajeConfirmacion.MENSAJE_DE_ORDEN_EXITOSA);
        }catch (Exception e){
            System.out.println("Error al verificar el movimiento del elemento: " + e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }finally {
            driver.quit();
        }
    }
}
