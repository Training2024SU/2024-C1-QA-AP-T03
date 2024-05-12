package co.com.sofkau.page;


import co.com.sofkau.page.function.FunctionCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static co.com.sofkau.constant.UrlConstant.URL;

public class ProductosPage extends FunctionCommon {

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Añadir al carrito')]")
    private List<WebElement> productosDisponibles;
    @CacheLookup
    @FindBy(css = "span.cart-price")
    private WebElement carritoCompras;

    @CacheLookup
    @FindBy(css = "div#cart-popup li")
    private List<WebElement> productosEnCarrito;
    @CacheLookup
    @FindBy(css= "div#cart-popup li span.amount")
    private List<WebElement> preciosProductoCarrito;
    @CacheLookup
    @FindBy(xpath = "//a[@class ='button checkout wc-forward']")
    private static WebElement BOTON_FINALIZAR_COMPRA;
    @CacheLookup
    @FindBy(xpath = "//ul[not(contains(@class,'mobile-nav'))]//a[@title='Carrito']")
    private static WebElement BOTON_CARRITO;
    @CacheLookup
    @FindBy(css = "div.blockUI")
    private List<WebElement> carritoCargandoBlocks;
    private String selectorProductoCarritos = "//li[@class='woocommerce-mini-cart-item mini_cart_item']";

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
            waitForElementVisible(productoParaAgregar);

            agregarProductoAlCarrito(productoParaAgregar);
        }
    }

    public void abrirModalCarritoDeCompras(){
        clickSelection(carritoCompras);
        WebElement carritoPrecioTotal = driver.findElement(By.xpath("//div[contains(@class, 'ux-mini-cart-footer')]//span[contains(@class, 'amount')]"));

        waitForElementVisible(carritoPrecioTotal);
    }

    public void modificarCarritoConProductoYCantidad(int producto, int cantidad){

        for(int i = 0 ; i < cantidad; i++){

            WebElement aumentarCantidadProducto = driver.findElement(
                    By.xpath("//li[@class='woocommerce-mini-cart-item mini_cart_item'][" + producto + "]//input[@value='+']"));

            clickSelection(aumentarCantidadProducto);

            esperarPorCargaDeCantidades();

        }

    }

    public int obtenerCantidadDeProduto(int producto) {
        esperarPorCargaDeCantidades();

        WebElement productoARetornar = driver.findElement(By.xpath(selectorProductoCarritos + "[" + producto + "]"));

        String CANTIDAD_PRODUCTO_CARRITO_SELECTOR = "input[type='number']";
        WebElement cantidadDeProducto = productoARetornar.findElement(By.cssSelector(CANTIDAD_PRODUCTO_CARRITO_SELECTOR));

        String valorCantidadProducto = cantidadDeProducto.getAttribute("value");

        return Integer.parseInt(valorCantidadProducto);
    }

    private void esperarPorCargaDeCantidades(){
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
        WebElement carritoPrecioTotal = driver.findElement(By.xpath("//div[contains(@class, 'ux-mini-cart-footer')]//span[contains(@class, 'amount')]"));

        String valorCarritoPrecioTotal = carritoPrecioTotal.getText();

        return Double.parseDouble(valorCarritoPrecioTotal.substring(1));
    }

    public void abrirModalCarrito(){
        waitForElementVisible(BOTON_CARRITO);
        clickSelection(BOTON_CARRITO);
    }

    private void agregarProductoAlCarrito(WebElement producto){
        clickSelection(producto);

        WebElement cerrarModalProductoSeleccionado = driver.findElement(By.xpath("//button[@title='Close (Esc)']"));

        waitForElementVisible(cerrarModalProductoSeleccionado);
        clickSelection(cerrarModalProductoSeleccionado);
        waitForElementInvisible(cerrarModalProductoSeleccionado);

    }

    public static void confirmarProductos(){
        clickSelection(BOTON_FINALIZAR_COMPRA);
    }

}
