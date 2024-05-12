package co.com.sofka.page;

import co.com.sofka.model.FormularioModel;
import co.com.sofka.page.function.FunctionsCommon;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormularioPage extends FunctionsCommon {
    private final FormularioModel usuario;
    private final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    // constructor
    public FormularioPage(WebDriver driver, FormularioModel usuario) {
        super(driver);
        this.usuario = usuario;
        PageFactory.initElements(driver, this);
    }

    // localizadores
    @CacheLookup
    @FindBy(css = "a[data-open='#login-form-popup'] span")
    private WebElement BOTON_INICIO_SESION;
    @CacheLookup
    @FindBy(id = "password")
    private WebElement CAMPO_CONTRASENA;
    @CacheLookup
    @FindBy(id = "username")
    private WebElement CAMPO_EMAIL;
    @CacheLookup
    @FindBy(css = "button[name='login']")
    private WebElement BOTON_SUBMIT;
    @CacheLookup
    @FindBy(css = "span[class='header-account-title']")
    private WebElement MENSAJE_SESION_INICIADA;
    @CacheLookup
    @FindBy(css = "img[class='header-logo-dark']")
    private WebElement CARGO_IMG_ZONAFIT;
    @CacheLookup
    @FindBy(id = "menu-item-309828")
    private WebElement BOTON_MENOS200;
    @CacheLookup
    @FindBy(xpath = "//a[contains(@href, '?add-to-cart')]")
    private List<WebElement> productosDisponibles;
    @CacheLookup
    @FindBy(css = "button.mfp-close")
    private WebElement cerrarCarrito;
    @CacheLookup
    @FindBy(css = "[data-open='#cart-popup']")
    private WebElement mostrarCarrito;
    @CacheLookup
    @FindBy(css = "a[class*='button wc-forward']")
    private WebElement verCarrito;
    @CacheLookup
    @FindBy(css = "a[class*='checkout-button button alt wc-forward']")
    private WebElement finalizarCompras;
    @CacheLookup
    @FindBy(css = "input[id=\"billing_myfield12\"]")
    private WebElement numeroFacturacion;
    @CacheLookup
    @FindBy(id = "billing_first_name")
    private WebElement primerNombre;
    @CacheLookup
    @FindBy(id = "billing_last_name")
    private WebElement segundoNombre;
    @CacheLookup
    @FindBy(css = "[aria-label='Departamento']")
    private WebElement departamento;
    @CacheLookup
    @FindBy(id = "billing_city")
    private WebElement ciudad;
    @CacheLookup
    @FindBy(css = "option[value='Valledupar']")
    private WebElement seleccionCiudad;
    @CacheLookup
    @FindBy(id = "billing_address_1")
    private WebElement direccion;
    @CacheLookup
    @FindBy(id = "billing_address_2")
    private WebElement apartamento;
    @CacheLookup
    @FindBy(id = "billing_phone")
    private WebElement whatsapp;
    @CacheLookup
    @FindBy(css = "label input[id='terms']")
    private WebElement terminosCondiciones;

    @CacheLookup
    @FindBy(css = "#payment > div.blockUI.blockOverlay")
    private WebElement esperaFacturacion;
    @CacheLookup
    @FindBy(id = "place_order")
    private WebElement realizarPedido;

    @CacheLookup
    @FindBy(xpath = "//*[text()='Gracias. Tu pedido ha sido recibido.']")
    private WebElement mensajeFacturacion;


    // funciones
    public void llenarFormulario() {
        esperarCarguePagina();
        wait.until(d -> BOTON_INICIO_SESION.isDisplayed());
        clickSelection(BOTON_INICIO_SESION);
        ingresarTexto(CAMPO_EMAIL, usuario.getEmail());
        ingresarTexto(CAMPO_CONTRASENA, usuario.getContrasena());
    }

    public void confirmarInicioSesion() {
        scrollTo(BOTON_SUBMIT);
        clickSelection(BOTON_SUBMIT);
        esperarCarguePagina();
    }

    public String obtenerMensajeLoguedo() {
        wait.until(d -> MENSAJE_SESION_INICIADA.isDisplayed());
        return obtenerTexto(MENSAJE_SESION_INICIADA);
    }

    public void seleccionMenos200() {
        clickSelection(BOTON_MENOS200);
        esperarCarguePagina();
    }

    public void seteccionarProductos(int producto) {
        WebElement productosParaAgregar = productosDisponibles.get(producto);
        agregarProducto(productosParaAgregar);
    }

    public void agregarProducto(WebElement product) {
        wait.until(d -> product.isDisplayed());
        scrollTo(product);
        clickSelection(product);
        wait.until(d -> cerrarCarrito.isDisplayed());
        cerrarCarrito.sendKeys(Keys.ESCAPE);
    }

    public void finalizarCompra() {
        esperarElementoVisible(mostrarCarrito);
        scrollTo(mostrarCarrito);
        clickSelection(mostrarCarrito);
    }

    public void irAlCarrito() {
        esperarElementoVisible(verCarrito);
        clickSelection(verCarrito);
    }

    public void irAComprar() {
        esperarElementoVisible(finalizarCompras);
        scrollTo(finalizarCompras);
        clickSelection(finalizarCompras);
    }

    public void llenarFacturacion() {
        ingresarTexto(numeroFacturacion, "3186594878");
        numeroFacturacion.sendKeys(Keys.TAB);
        primerNombre.clear();
        ingresarTexto(primerNombre, "Juanes");
        segundoNombre.clear();
        ingresarTexto(segundoNombre, "Velasquez");
        ingresarTexto(departamento, "cesar");
        departamento.sendKeys(Keys.TAB);
        scrollTo(ciudad);
        clickSelection(ciudad);
        clickSelection(seleccionCiudad);
        clickSelection(ciudad);
        direccion.clear();
        ingresarTexto(direccion, "calle 33");
        apartamento.clear();
        ingresarTexto(apartamento, "apartamento 2");
        whatsapp.clear();
        ingresarTexto(whatsapp, "1065832254");
        scrollTo(whatsapp);

        esperarElementoVisible(esperaFacturacion);
        esperarElementoInvisible(esperaFacturacion);
        scrollTo(terminosCondiciones);
        clickSelection(terminosCondiciones);
        clickSelection(realizarPedido);
    }

    public String obtenerMensajeFacturacion() {
        wait.until(d -> mensajeFacturacion.isDisplayed());
        return obtenerTexto(mensajeFacturacion);
    }
}