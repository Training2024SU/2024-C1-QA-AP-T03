package co.com.prueba.stepdefinitions.exito;

import co.com.prueba.page.exitopage.PageAgregarVariosProductoCarrito;
import co.com.prueba.page.exitopage.PageFactoryCompraProducto;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

public class AddVariosProductosAlcarritoStepD extends WebSetup {
    PageAgregarVariosProductoCarrito agregar;

    @Cuando("agrega varios productos al carrito")
    public void agregaVariosProductosAlCarrito() {
        try {
            agregar = new PageAgregarVariosProductoCarrito(driver);
            agregar.agregarProductos();
        }catch (Exception e) {
            e.getMessage();
        }
    }
    @Entonces("deberia poder realizar la compra de todos los productos")
    public void deberiaPoderRealizarLaCompraDeTodosLosProductos(){
        try {
            agregar = new PageAgregarVariosProductoCarrito(driver);
            agregar.datosCompra();
            Assert.assertFalse(agregar.datosCompra().isEmpty());
        }catch (Exception e) {
            e.getMessage();
        }finally {
            quiteDrive();
        }
    }
}
