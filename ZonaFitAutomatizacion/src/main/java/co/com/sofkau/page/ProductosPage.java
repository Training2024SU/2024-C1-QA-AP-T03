package co.com.sofkau.page;


import co.com.sofkau.page.function.FunctionCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductosPage extends FunctionCommon {

    private final static String URL = "https://zonafit.co/shop/";

    private final String AUMENTAR_PRODUCTO_CARRITO_SELECTOR = "input[value='+']";

    private final String CANTIDAD_PRODUCTO_CARRITO_SELECTOR = "input[type='number']";

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    private WebElement cerrarModalProductoSeleccionado;

    @FindBy(xpath = "//a[contains(text(),'Añadir al carrito')]")
    private List<WebElement> productosDisponibles;

    @FindBy(css = "span.cart-price")
    private WebElement carritoCompras;

    @FindBy(xpath = "//div[contains(@class, 'ux-mini-cart-footer')]//span[contains(@class, 'amount')]")
    private WebElement carritoPrecioTotal;

    @FindBy(css = "div#cart-popup li")
    private List<WebElement> productosEnCarrito;

    @FindBy(css= "div#cart-popup li span.amount")
    private List<WebElement> preciosProductoCarrito;


    @FindBy(css = "div.blockUI")
    private List<WebElement> carritoCargandoBlocks;

    public ProductosPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarAProductos(){

        driver.get(URL);
        waitForGeneralPageLoad();

    }

    public void seleccionarProductos(int cantidad){

        for(int i = 0; i < cantidad; i++){
            WebElement productoParaAgregar = productosDisponibles.get(i);

            agregarProductoAlCarrito(productoParaAgregar);
        }
    }

    public void abrirModalCarritoDeCompras(){
        clickSelection(carritoCompras);

        waitForElementVisible(carritoPrecioTotal);
    }

    public void modificarCarritoConProductoYCantidad(int producto, int cantidad){

        for(int i = 0 ; i < cantidad; i++){
            WebElement productoAModiicar = productosEnCarrito.get(producto);
            agregarNuevoProductoACarrito(productoAModiicar);
        }

    }


    public int obtenerCantidadDeProduto(int producto) {
        WebElement productoARetornar = productosEnCarrito.get(producto);

        WebElement cantidadDeProducto = productoARetornar.findElement(By.cssSelector(CANTIDAD_PRODUCTO_CARRITO_SELECTOR));

        String valorCantidadProducto = cantidadDeProducto.getAttribute("value");

        return Integer.parseInt(valorCantidadProducto);
    }

    public void agregarNuevoProductoACarrito(WebElement producto){
        WebElement aumentarCantidadProducto = producto.findElement(By.cssSelector(AUMENTAR_PRODUCTO_CARRITO_SELECTOR));

        clickSelection(aumentarCantidadProducto);

        List<WebElement> elementosCargando = driver.findElements(By.cssSelector("div.blockUI"));

        for (WebElement element : elementosCargando) {
            waitForElementInvisible(element);
        }

    }

    public double obtenerSumatoriaDePrecios(){
        double total = 0;

        for(WebElement precioProducto : preciosProductoCarrito){

            String valorPrecio = precioProducto.getText();

            total += Double.parseDouble(valorPrecio.substring(1));
        }

        return total;
    }

    public double obtenerTotalDePrecios(){
        String valorCarritoPrecioTotal = carritoPrecioTotal.getText();

        return Double.parseDouble(valorCarritoPrecioTotal.substring(1));
    }


    private void agregarProductoAlCarrito(WebElement producto){
        clickSelection(producto);
        clickSelection(cerrarModalProductoSeleccionado);
        waitForElementInvisible(cerrarModalProductoSeleccionado);

    }



}
