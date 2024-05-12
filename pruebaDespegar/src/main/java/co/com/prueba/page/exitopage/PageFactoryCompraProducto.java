package co.com.prueba.page.exitopage;

import co.com.prueba.page.functions.FunctionCommons;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static co.com.prueba.page.exitopage.constantexitopage.ConstansExitoPage.*;
import static co.com.prueba.util.ConstantesWait.NOMBRE;
import static co.com.prueba.util.ConstantesWait.WAIT_TIME;
import static co.com.prueba.util.ExplicitWaitHelper.*;

public class PageFactoryCompraProducto extends FunctionCommons {
    @CacheLookup
    @FindBy(css = "input[placeholder='Buscar en exito.com']")
    private WebElement CAMPO_BUSQUEDA;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/header/section/div/div[1]/div[2]/form/button")
    private WebElement BOTON_BUSCAR;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/main/section[3]/div/div[2]/div[2]/div[2]/ul/li[1]/article/section/div[2]/div[2]/button/span")
    private WebElement BOTON_AGREGAR;
    @CacheLookup
    @FindBy(xpath = "//*[@id='__next']/header/section/div/div[2]/div[2]/button")
    private WebElement CARRITO;

    //css="div.exito-checkout-io-0-x-paymentButtonContentText"
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
    @FindBy(xpath = "//*[@id='render-store.custom.checkout-io']/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div/form/div[4]/article[1]/label/div/input")
    private WebElement CHECK_TERMINOS;
    @CacheLookup
    @FindBy(xpath = "//*[@id='render-store.custom.checkout-io']/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div/form/div[4]/article[2]/label/div/input")
    private WebElement CHECK_TRATAMIENTO_DATOS;
    @CacheLookup
    @FindBy(xpath = "//*[@id='render-store.custom.checkout-io']/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/section/div[2]/button")
    private WebElement BOTON_CONTINUAR;
    @CacheLookup
    @FindBy(css = "select[name='state']")
    private WebElement CAMPO_DEPARTAMENTO;
    @CacheLookup
    @FindBy(css = "option[value='Antioquia']")
    private WebElement SELECT_DEPARTAMENTO;
    @CacheLookup
    @FindBy(css = "select[name='city']")
    private WebElement CAMPO_CIUDAD;
    @CacheLookup
    @FindBy(css = "option[value='Carepa-05147']")
    private WebElement SELECT_CIUDAD;
    @CacheLookup
    @FindBy(css = "select[name='type']")
    private WebElement CAMPO_TIPO_DIRECCION;
    @CacheLookup
    @FindBy(css = "option[value='Calle']")
    private WebElement SELECT_TIPO_DIRECCION;
    @CacheLookup
    @FindBy(css = "input[placeholder='Ej: 18']")
    private WebElement CAMPO_NUMERO_CALLE;
    @CacheLookup
    @FindBy(css = "input[placeholder='79A']")
    private WebElement CAMPO_NUMERO_CALLE_2;
    @CacheLookup
    @FindBy(css = "input[name='secondNumber']")
    private WebElement CAMPO_NUMERO_CALLE_2_2;
    @CacheLookup
    @FindBy(css = "input[placeholder='Ej: Los Colores']")
    private WebElement CAMPO_BARRIO;
    @CacheLookup
    @FindBy(css = "input[placeholder='Ej: Carlos']")
    private WebElement CAMPO_NOMBRE_RECIBE;
    @CacheLookup
    @FindBy(xpath = "//*[@id='render-store.custom.checkout-io']/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div/article/div/div/div[2]/div/div[3]/div/div/section/div[2]/section/section/form/div[6]/label/input")
    private WebElement CAMPO_CASA;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Guardar']")
    private WebElement BOTON_GUARDAR;
    @CacheLookup
    @FindBy(id = "orderform-title")
    private WebElement DATOS_COMPRA;

    public PageFactoryCompraProducto(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void seleccionarProducto() {
        waitForElementClickable(driver, CAMPO_BUSQUEDA, 5);
        clickSelection(CAMPO_BUSQUEDA);
        typeInto(CAMPO_BUSQUEDA, PRODUCTO);
        clickSelection(BOTON_BUSCAR);
        waitForElementClickable(driver, BOTON_AGREGAR, 10);
        clickSelection(BOTON_AGREGAR);
        waitForElementClickable(driver, CARRITO, 5);
        clickSelection(CARRITO);
    }

    public void continuarProcesoPago() {
        waitForElementClickable(driver, CARRITO, 10);
        waitForElementVisibility(driver, BOTON_IR_PAGAR, 10);
        waitForElementClickable(driver, BOTON_IR_PAGAR, 10);
        waitSeconds(1);
        clickSelection(BOTON_IR_PAGAR);
        typeInto(CAMPO_INGRESA_CORREO, CORREO);
        waitForElementClickable(driver, BOTON_CONFIRMAR, 3);
        clickSelection(BOTON_CONFIRMAR);
        waitForElementVisibility(driver, CAMPO_FIRST_NAME, 20);
        waitForElementClickable(driver, CAMPO_FIRST_NAME, 10);
        clickSelection(CAMPO_LAST_NAME);
    }

    public void llenarFormularioCompra(String nom, String ape, String ced, String tel) {
        waitForElementClickable(driver, CAMPO_FIRST_NAME, 10);
        CAMPO_FIRST_NAME.clear();
        clickSelection(CAMPO_FIRST_NAME);
        waitSeconds(1);
        CAMPO_FIRST_NAME.clear();
        typeInto(CAMPO_FIRST_NAME, nom);
        scrollTo(CAMPO_LAST_NAME);
        clickSelection(CAMPO_LAST_NAME);
        CAMPO_LAST_NAME.clear();
        waitSeconds(1);
        typeInto(CAMPO_LAST_NAME, ape);
        scrollTo(CAMPO_DOCUMENT);
        clickSelection(CAMPO_DOCUMENT);
        CAMPO_DOCUMENT.clear();
        //waitSeconds(1);
        typeInto(CAMPO_DOCUMENT, ced);
        scrollTo(CAMPO_TELEFONO);
        clickSelection(CAMPO_TELEFONO);
        CAMPO_TELEFONO.clear();
        waitSeconds(1);
        typeInto(CAMPO_TELEFONO, tel);
        waitSeconds(1);
        scrollTo(CHECK_TERMINOS);
        clickSelection(CHECK_TERMINOS);
        clickSelection(CHECK_TRATAMIENTO_DATOS);
        waitForElementClickable(driver, BOTON_CONTINUAR, 20);
        clickSelection(BOTON_CONTINUAR);
        waitForElementClickable(driver, CAMPO_DEPARTAMENTO, 10);
    }

    public void llenarFormularioDireccion() {
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
        typeInto(CAMPO_BARRIO, BARRIO);
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

