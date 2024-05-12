package co.com.sofka.page;

import co.com.sofka.model.FormPersonaModel;
import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatosUsuarioPage  extends FunctionsCommon {

    private FormPersonaModel formPersonaModel;

    public DatosUsuarioPage(WebDriver driver, FormPersonaModel formPersonaModel) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.formPersonaModel = formPersonaModel;
    }

    // localizadores

    @CacheLookup
    @FindBy(css="input[name='firstName']")
    private WebElement INPUT_NOMBRE;

    @CacheLookup
    @FindBy(css="input[name='lastName']")
    private WebElement INPUT_APELLIDO;

    @CacheLookup
    @FindBy(css="input[name='document']")
    private WebElement INPUT_DOCUMENTO;

    @CacheLookup
    @FindBy(css="input[name='phone']")
    private WebElement INPUT_PHONE;

    @CacheLookup
    @FindBy(xpath="(//input[@data-atom-checkbox-input])[1]")
    private WebElement CHECKBOX_CONDICIONES;

    @CacheLookup
    @FindBy(xpath="(//input[@data-atom-checkbox-input])[2]")
    private WebElement CHECKBOX_DATOS;

    @CacheLookup
    @FindBy(xpath="(//input[@data-atom-checkbox-input])[3]")
    private WebElement CHECKBOX_PUBLICIDAD;

    @CacheLookup
    @FindBy(css="div.exito-checkout-io-0-x-paymentButtonContentText")
    private WebElement BUTTON_IR_PAGAR;

    @CacheLookup
    @FindBy(xpath="//span[@class='exito-checkout-io-0-x-paymentButtonText']")
    private WebElement BUTTON_IR_PAGAR_ENVIO;

    @CacheLookup
    @FindBy(css="svg.exito-checkout-io-0-x-shippingPickupPointIcon")
    private WebElement BUTTON_RECOGER_TIENDA;

    @CacheLookup
    @FindBy(xpath="//input[contains(@placeholder,'ciudad')]")
    private WebElement INPUT_SELECT_CIUDAD;

    @CacheLookup
    @FindBy(xpath="(//li[@class='exito-checkout-io-0-x-pickUpDependenciesCard'][1]//button)[1]")
    private WebElement SELECT_ALMACEN;
    @CacheLookup
    @FindBy(xpath="(//li[@data-atom-suggestion-item-autocomplete])[1]")
    private WebElement SELECT_CIUDAD;

    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Pago en')]")
    private WebElement OPCION_PAGO;

    @CacheLookup
    @FindBy(xpath="//button[@id='payment-data-submit']//span[@data-i18n='paymentData.confirm']")
    private WebElement BUTTON_FINALIZAR;

    @CacheLookup
    @FindBy(xpath="//p[contains(@class,'exito-order-placed-2-x-headerThanks')]")
    private WebElement LABEL_PEDIDO_CONFIRMADO;

    @CacheLookup
    @FindBy(xpath="//span[@class='exito-checkout-io-0-x-dependencySelectedStoreCity']")
    private WebElement LABEL_CIUDAD;



    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(30));



    // funciones
    public void llenarFormularioInfoPersona(){

        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_PHONE));
        scrollTo(INPUT_PHONE);
        ewait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_DATOS));
        clickSelection(CHECKBOX_DATOS);
        clickSelection(CHECKBOX_CONDICIONES);
        clickSelection(CHECKBOX_PUBLICIDAD);

        clickSelection(INPUT_NOMBRE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        typeInto(INPUT_NOMBRE,formPersonaModel.getNombre());
        typeKey(INPUT_NOMBRE, Keys.TAB);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        typeInto(INPUT_APELLIDO,formPersonaModel.getApellido());
        typeKey(INPUT_APELLIDO, Keys.TAB);
        typeKey(INPUT_APELLIDO, Keys.TAB);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        typeInto(INPUT_DOCUMENTO,formPersonaModel.getNumerodoc());

        typeKey(INPUT_DOCUMENTO, Keys.TAB);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        typeInto(INPUT_PHONE,formPersonaModel.getCelular());

        ewait.until(ExpectedConditions.elementToBeClickable(BUTTON_IR_PAGAR_ENVIO));
        scrollTo(BUTTON_IR_PAGAR_ENVIO);
        clickSelection(BUTTON_IR_PAGAR_ENVIO);
    }

    public void llenarFormularioRecogerPersona() throws InterruptedException {
        ewait.until(ExpectedConditions.elementToBeClickable(BUTTON_RECOGER_TIENDA));
        clickSelection(BUTTON_RECOGER_TIENDA);
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_SELECT_CIUDAD));
        clickSelection(INPUT_SELECT_CIUDAD);
        typeInto(INPUT_SELECT_CIUDAD,formPersonaModel.getCiudad());
        ewait.until(ExpectedConditions.elementToBeClickable(SELECT_CIUDAD));
        clickSelection(SELECT_CIUDAD);
        ewait.until(ExpectedConditions.elementToBeClickable(SELECT_ALMACEN));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickSelection(SELECT_ALMACEN);
//        ewait.until(ExpectedConditions.elementToBeClickable(BUTTON_IR_PAGAR));
//        clickSelection(BUTTON_IR_PAGAR);
    }

    public void llenarFormPago(){
        ewait.until(ExpectedConditions.elementToBeClickable(OPCION_PAGO));
        scrollTo(OPCION_PAGO);
        clickSelection(OPCION_PAGO);
        ewait.until(ExpectedConditions.elementToBeClickable(BUTTON_FINALIZAR));
        clickSelection(BUTTON_FINALIZAR);
    }

    public void getConformarPedido(){
        ewait.until(ExpectedConditions.visibilityOf(LABEL_PEDIDO_CONFIRMADO));
        String prueba = getText(LABEL_PEDIDO_CONFIRMADO);
        System.out.println(prueba);
    }

    public String getTextEnvio(){
       if(getText(LABEL_CIUDAD).contains(formPersonaModel.getCiudad())){
           return formPersonaModel.getCiudad();
       }else{
           return null;
       }
    }




}
