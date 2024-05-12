package co.com.prueba.page.exitopage;

import co.com.prueba.page.functions.FunctionCommons;
import com.github.javafaker.Faker;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Locale;

import static co.com.prueba.page.exitopage.constantexitopage.ConstansExitoPage.*;
import static co.com.prueba.util.ConstantesWait.WAIT_TIME;
import static co.com.prueba.util.ExplicitWaitHelper.*;

public class PageAgregarVariosProductoCarrito extends FunctionCommons {
    @CacheLookup
    @FindBy(css = "input[placeholder='Buscar en exito.com']")
    private WebElement CAMPO_BUSQUEDA;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/header/section/div/div[1]/div[2]/form/button")
    private WebElement BOTON_BUSCAR;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/main/section[3]/div/div[2]/div[2]/div[2]/ul/li[1]/article/section/div[2]/div[2]/button/span")
    private WebElement PRODUCTO_1;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/main/section[3]/div/div[2]/div[2]/div[2]/ul/li[2]/article/section/div[2]/div[2]/button")
    private WebElement PRODUCTO_2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/main/section[3]/div/div[2]/div[2]/div[2]/ul/li[1]/article/section/div[2]/div[2]/button")
    private WebElement PRODUCTO_3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/header/section/div/div[2]/div[2]/button")
    private WebElement CARRITO;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Seguir comprando']")
    private WebElement BOTON_SEGUIR_COMPRANDO;
    @CacheLookup
    @FindBy(xpath = "//span[text()='Ir a pagar /']")
    private WebElement BOTON_IR_PAGAR;
    @CacheLookup
    @FindBy(css = "input[type='email']")
    private WebElement CAMPO_INGRESA_CORREO;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Confirmar']")
    private WebElement BOTON_CONFIRMAR;
    @CacheLookup
    @FindBy(css = "input[name='firstName']")
    private WebElement CAMPO_FIRST_NAME;
    @CacheLookup
    @FindBy(css = "input[name='lastName']")
    private WebElement CAMPO_LAST_NAME;
    @CacheLookup
    @FindBy(css = "input[name='document']")
    private WebElement CAMPO_DOCUMENT;
    @CacheLookup
    @FindBy(css = "input[name='phone']")
    private WebElement CAMPO_TELEFONO;
    @CacheLookup
    @FindBy(xpath = "//*[@id='render-store.custom.checkout-io']/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div/form/div[3]/article[1]/label/div/input")
    private WebElement CHECK_TERMINOS;
    @CacheLookup
    @FindBy(xpath = "//*[@id='render-store.custom.checkout-io']/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div/form/div[3]/article[2]/label/div/input")
    private WebElement CHECK_TRATAMIENTO_DATOS;
    @CacheLookup
    @FindBy(xpath = "//*[@id='render-store.custom.checkout-io']/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/section/div[2]/button")
    private WebElement BOTON_CONTINUAR;


    @FindBy(css = "select[name='state']")
    private WebElement CAMPO_DEPARTAMENTO;
    @CacheLookup
    @FindBy(css = "option[value='Atlántico']")
    private WebElement SELECT_DEPARTAMENTO;
    @CacheLookup
    @FindBy(css = "select[name='city']")
    private WebElement CAMPO_CIUDAD;
    @CacheLookup
    @FindBy(css = "option[value='Barranquilla-08001']")
    private WebElement SELECT_CIUDAD;
    @CacheLookup
    @FindBy(css = "select[name='type']")
    private WebElement CAMPO_TIPO_DIRECCION;
    @CacheLookup
    @FindBy(css = "option[value='Av. Transversal']")
    private WebElement SELECT_TIPO_DIRECCION;
    @CacheLookup
    @FindBy(css = "input[name='mainAddress']")
    private WebElement CAMPO_NUMERO_CALLE;
    @CacheLookup
    @FindBy(css = "input[name='firstNumber']")
    private WebElement CAMPO_NUMERO_CALLE_2;
    @CacheLookup
    @FindBy(css = "input[name='secondNumber']")
    private WebElement CAMPO_NUMERO_CALLE_2_2;
    @CacheLookup
    @FindBy(css = "input[name='neighborhood']")
    private WebElement CAMPO_BARRIO;
    @CacheLookup
    @FindBy(css = "input[name='complement']")
    private WebElement CAMPO_CASA;
    @CacheLookup
    @FindBy(css = "input[name='receiverName']")
    private WebElement CAMPO_NOMBRE_RECIBE;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Guardar']")
    private WebElement BOTON_GUARDAR;
    @CacheLookup
    @FindBy(id = "orderform-title")
    private WebElement DATOS_COMPRA;

    public PageAgregarVariosProductoCarrito(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void agregarProductos() {
        waitForElementClickable(driver, CAMPO_BUSQUEDA, 5);
        clickSelection(CAMPO_BUSQUEDA);
        typeInto(CAMPO_BUSQUEDA, PRODUCTO_BUSQUEDA);
        clickSelection(BOTON_BUSCAR);
        waitForElementClickable(driver, PRODUCTO_1, 10);
        waitForElementPresence(driver, PRODUCTO_1, 5);
        clickSelection(PRODUCTO_1);
        scrollTo(CARRITO);
        clickSelection(CARRITO);
        waitSeconds(1);
        waitForElementClickable(driver, BOTON_SEGUIR_COMPRANDO, 10);
        clickSelection(BOTON_SEGUIR_COMPRANDO);
        seleccionarProductos();
        waitForElementPresence(driver, PRODUCTO_2, 20);
        waitForElementClickable(driver, PRODUCTO_2, 10);
        waitSeconds(1);
        clickSelection(PRODUCTO_2);
        scrollTo(CARRITO);
        clickSelection(CARRITO);
        waitForElementClickable(driver, BOTON_SEGUIR_COMPRANDO, 20);
        clickSelection(BOTON_SEGUIR_COMPRANDO);
        seleccionarProductos2();
        waitForElementPresence(driver, PRODUCTO_3, 20);
        waitForElementClickable(driver, PRODUCTO_3, 10);
        waitSeconds(1);
        clickSelection(PRODUCTO_3);
        scrollTo(CARRITO);
        clickSelection(CARRITO);
        llenarDatosPago();
        llenarFormularioPago();
        waitSeconds(1);
        waitForElementClickable(driver, CHECK_TERMINOS, 10);
        clickSelection(CHECK_TERMINOS);
        clickSelection(CHECK_TRATAMIENTO_DATOS);
        waitForElementClickable(driver, BOTON_CONTINUAR, 20);
        clickSelection(BOTON_CONTINUAR);
        llenarFormularioDireccion();
    }
    public void seleccionarProductos() {
        try {
            CAMPO_BUSQUEDA.click(); // Intentar interactuar con el elemento
        } catch (StaleElementReferenceException e) {
            // Si se produce un StaleElementReferenceException, reinicializa los elementos de la página
            PageFactory.initElements(driver, this);
            CAMPO_BUSQUEDA.click(); // Intentar interactuar con el elemento nuevamente
        }
        waitForElementClickable(driver, CAMPO_BUSQUEDA, 5);
        waitSeconds(1);
        clickSelection(CAMPO_BUSQUEDA);
        typeInto(CAMPO_BUSQUEDA, PRODUCTO_BUSQUEDA);
        clickSelection(BOTON_BUSCAR);
    }

    public void seleccionarProductos2() {
        try {
            CAMPO_BUSQUEDA.click();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            CAMPO_BUSQUEDA.click();
        }
        waitForElementClickable(driver, CAMPO_BUSQUEDA, 5);
        waitSeconds(1);
        clickSelection(CAMPO_BUSQUEDA);
        typeInto(CAMPO_BUSQUEDA, PRODUCTO_BUSQUEDA_NUEVO);
        clickSelection(BOTON_BUSCAR);
    }

    public void llenarDatosPago(){
        waitForElementVisibility(driver, BOTON_IR_PAGAR, 10);
        waitForElementClickable(driver, BOTON_IR_PAGAR, 10);
        waitSeconds(1);
        clickSelection(BOTON_IR_PAGAR);
        typeInto(CAMPO_INGRESA_CORREO, CORREO);
        waitForElementClickable(driver, BOTON_CONFIRMAR, 3);
        clickSelection(BOTON_CONFIRMAR);
        waitForElementVisibility(driver, CAMPO_FIRST_NAME, 10);
    }

    public void llenarFormularioPago(){
        Faker faker = new Faker(new Locale("es"));
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        int primerDigito = faker.number().numberBetween(1, 10);
        StringBuilder restoCedulaBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            restoCedulaBuilder.append(faker.number().numberBetween(0, 10));
        }
        String numeroCedula = primerDigito + restoCedulaBuilder.toString();
        StringBuilder numeroCelularBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            numeroCelularBuilder.append(faker.number().numberBetween(0, 9));
        }
        String celular = numeroCelularBuilder.toString();
        String numeroCelular = "30"+celular;
        waitSeconds(1);
        CAMPO_FIRST_NAME.clear();
        typeInto(CAMPO_FIRST_NAME, nombre);
        waitSeconds(1);
        CAMPO_LAST_NAME.clear();
        typeInto(CAMPO_LAST_NAME, apellido);
        waitSeconds(1);
        CAMPO_DOCUMENT.clear();
        typeInto(CAMPO_DOCUMENT, numeroCedula);
        waitSeconds(1);
        CAMPO_TELEFONO.clear();
        typeInto(CAMPO_TELEFONO, numeroCelular);
    }

    public void llenarFormularioDireccion() {
        waitForElementPresence(driver,CAMPO_DEPARTAMENTO,10);
        clickSelection(CAMPO_DEPARTAMENTO);
        clickSelection(SELECT_DEPARTAMENTO);
        clickSelection(CAMPO_CIUDAD);
        clickSelection(SELECT_CIUDAD);
        clickSelection(CAMPO_TIPO_DIRECCION);
        clickSelection(SELECT_TIPO_DIRECCION);
        scrollTo(CHECK_TERMINOS);
        typeInto(CAMPO_NUMERO_CALLE, NUMERO_CALLE);
        typeInto(CAMPO_NUMERO_CALLE_2, NUMERO_CALLE_1);
        typeInto(CAMPO_NUMERO_CALLE_2_2, NUMERO_CALLE_1_2);
        scrollTo(CAMPO_BARRIO);
        typeInto(CAMPO_BARRIO, ELECCION_BARRIO);
        waitSeconds(1);
        typeInto(CAMPO_CASA, CASA);
        typeInto(CAMPO_NOMBRE_RECIBE, NOMBRE_RECIBE);
        scrollTo(BOTON_GUARDAR);
        clickSelection(BOTON_GUARDAR);
        waitForElementVisibility(driver, DATOS_COMPRA, 20);
    }

    public String datosCompra() {
        String mensaje = DATOS_COMPRA.getText();
        return mensaje;
    }

    public void waitSeconds(int seconds) {
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
        }
    }


}
