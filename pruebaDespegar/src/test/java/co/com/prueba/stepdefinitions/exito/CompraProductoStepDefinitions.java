package co.com.prueba.stepdefinitions.exito;

import co.com.prueba.page.exitopage.PageFactoryCompraProducto;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;


public class CompraProductoStepDefinitions extends WebSetup {
    PageFactoryCompraProducto compraProducto;

    @Dado("que el usuario esta en la pagina principal {int}")
    public void queElUsuarioEstaEnLaPaginaPrincipal(Integer typeDriver) {
        try {
            generalSetup(typeDriver);
        }catch (Exception e) {
            e.getMessage();
        }
    }

    @Cuando("seleciona un producto")
    public void selecionaUnProducto() {
        try {
            compraProducto = new PageFactoryCompraProducto(driver);
            compraProducto.seleccionarProducto();
        }catch (Exception e) {
            e.getMessage();
        }
    }

    @Cuando("continua con el proceso de pago")
    public void continuaConElProcesoDePago() {
        try {
            compraProducto = new PageFactoryCompraProducto(driver);
            compraProducto.continuarProcesoPago();
        }catch (Exception e) {
            e.getMessage();
        }
    }

    @Cuando("llena el formulario de pago con los datos {string},{string},{string} y {string}")
    public void llenaElFormularioDePagoConLosDatosY(String nombre, String apellido, String cedula, String telefono) {
        try {
            compraProducto = new PageFactoryCompraProducto(driver);
            compraProducto.llenarFormularioCompra(nombre, apellido, cedula, telefono);
            compraProducto.llenarFormularioDireccion();
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Entonces("entonces deberia mostrar una factura con los detalles de la compra")
    public void entoncesDeberiaMostrarUnaFacturaConLosDetallesDeLaCompra() {
        try {
            compraProducto = new PageFactoryCompraProducto(driver);
            compraProducto.datosCompra();
            Assert.assertFalse(compraProducto.datosCompra().isEmpty());
        }catch (Exception e){
            e.getMessage();
        }finally {
            quiteDrive();
        }
    }
}
