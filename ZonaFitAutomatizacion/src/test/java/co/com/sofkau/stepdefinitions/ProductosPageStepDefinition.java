package co.com.sofkau.stepdefinitions;

import co.com.sofkau.page.ProductosPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class ProductosPageStepDefinition extends WebSetup {

    ProductosPage productosPage;

    @Given("navega a la pagina de productos")
    public void navegarAProductos(){
        productosPage =  new ProductosPage(driver);

        productosPage.navegarAProductos();
    }

    @When("ingresa los {int} primeros productos disponibles al carrito")
    public void agregarProductosAlCarrito(int cantidadDeProdutos){
        productosPage.seleccionarProductos(cantidadDeProdutos);
    }

    @When("modifica la cantidad del producto {int} agregandole {int}")
    public void modifica_la_cantidad_del_producto_agregandole(Integer producto, Integer cantidad) {
        productosPage.abrirModalCarritoDeCompras();
        productosPage.modificarCarritoConProductoYCantidad(producto, cantidad);
    }
    @Then("deberia confirmarse los cambios en las cantidades del producto {int} es {int}")
    public void el_usuario_confirma_los_cambios_en_las_cantidades(Integer producto, Integer cantidad) {
        int cantidadDeProducto = productosPage.obtenerCantidadDeProduto(producto);
        Assertions.assertEquals(cantidadDeProducto, cantidad);
    }
    @Then("el precio del carrito de compras deberia reflejar las nuevas cantidades de los productos")
    public void el_carrito_de_compras_deberia_reflejar_las_nuevas_cantidades_de_los_productos() {

        double totalSumatoriaCadaProducto = productosPage.obtenerSumatoriaDePrecios();
        double totalDelCarrito = productosPage.obtenerTotalDePrecios();

        Assertions.assertEquals(totalDelCarrito, totalSumatoriaCadaProducto);
    }

    @When ("ingresa los {int} primeros productos disponibles al carrito, confirmando la compra")
    public void ingresaLosPrimerosProductosDisponibles(int cantidadDeProdutos){
        productosPage.seleccionarProductos(cantidadDeProdutos);
        productosPage.abrirModalCarrito();
        ProductosPage.confirmarProductos();
    }
    @Then("procede a completar la compra")
        public void confirmaLosProductosDelCarrito(){
         ProductosPage.confirmarProductos();
        }
}
