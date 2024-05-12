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
    @When("ingresa los {int} primeros productos disponibles al carrito")
    public void agregarProductosAlCarrito(int cantidadDeProdutos){
        try {
            productosPage.seleccionarProductos(cantidadDeProdutos);
        }catch (Exception e){
            System.out.println("Error al agregar productos en el carrito: " + e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }
    }

    @When("modifica la cantidad del producto {int} agregandole {int}")
    public void modifica_la_cantidad_del_producto_agregandole(Integer producto, Integer cantidad) {
        try {
            productosPage.abrirModalCarritoDeCompras();
            productosPage.modificarCarritoConProductoYCantidad(producto, cantidad);
        }catch (Exception e){
            System.out.println("Error al modificar producto en el carrito: " + e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("deberia confirmarse los cambios en las cantidades del producto {int} es {int}")
    public void el_usuario_confirma_los_cambios_en_las_cantidades(Integer producto, Integer cantidad) {
        try {
            int cantidadDeProducto = productosPage.obtenerCantidadDeProduto(producto);
            Assertions.assertEquals(cantidadDeProducto, cantidad);
        }catch (Exception e){
            System.out.println("Error al confirmar los cambios en las cantidades del producto: " + e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("el precio del carrito de compras deberia reflejar las nuevas cantidades de los productos")
    public void el_carrito_de_compras_deberia_reflejar_las_nuevas_cantidades_de_los_productos() {
        try{
            double totalSumatoriaCadaProducto = productosPage.obtenerSumatoriaDePrecios();
            double totalDelCarrito = productosPage.obtenerTotalDePrecios();

            Assertions.assertEquals(totalDelCarrito, totalSumatoriaCadaProducto);
        }catch (Exception e){
            System.out.println("Error al completar la compra: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail();
        }finally {
            quiteDriver();
        }
    }
}
