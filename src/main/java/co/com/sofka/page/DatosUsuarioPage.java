package co.com.sofka.page;

import co.com.sofka.model.FormPersonaModel;
import co.com.sofka.util.functions.FunctionsCommon;
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
    @FindBy(css="svg.exito-checkout-io-0-x-shippingPickupPointIcon")
    private WebElement BUTTON_RECOGER_TIENDA;

    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // localizadores
    public void llenarFormularioInfoPersona(){

        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_PHONE));
        scrollTo(INPUT_PHONE);
        ewait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_DATOS));
        clickSelection(CHECKBOX_DATOS);
        clickSelection(CHECKBOX_CONDICIONES);
        clickSelection(CHECKBOX_PUBLICIDAD);
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_NOMBRE));
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_APELLIDO));
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_DOCUMENTO));
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_PHONE));


        clickSelection(INPUT_NOMBRE);
        typeInto(INPUT_NOMBRE,formPersonaModel.getNombre());
        clickSelection(INPUT_APELLIDO);
        typeInto(INPUT_APELLIDO,formPersonaModel.getApellido());
        clickSelection(INPUT_DOCUMENTO);
        typeInto(INPUT_DOCUMENTO,formPersonaModel.getNumerodoc());

        clickSelection(INPUT_PHONE);
        typeInto(INPUT_PHONE,formPersonaModel.getCelular());

        scrollTo(BUTTON_IR_PAGAR);
        clickSelection(BUTTON_IR_PAGAR);
    }

    public void llenarFormularioRecogerPersona(){

        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_PHONE));
        scrollTo(INPUT_PHONE);
        ewait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_DATOS));
        clickSelection(CHECKBOX_DATOS);
        clickSelection(CHECKBOX_CONDICIONES);
        clickSelection(CHECKBOX_PUBLICIDAD);
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_NOMBRE));
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_APELLIDO));
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_DOCUMENTO));
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_PHONE));


        clickSelection(INPUT_NOMBRE);
        typeInto(INPUT_NOMBRE,formPersonaModel.getNombre());
        clickSelection(INPUT_APELLIDO);
        typeInto(INPUT_APELLIDO,formPersonaModel.getApellido());
        clickSelection(INPUT_DOCUMENTO);
        typeInto(INPUT_DOCUMENTO,formPersonaModel.getNumerodoc());

        clickSelection(INPUT_PHONE);
        typeInto(INPUT_PHONE,formPersonaModel.getCelular());

        scrollTo(BUTTON_IR_PAGAR);
        clickSelection(BUTTON_IR_PAGAR);
    }

    // funciones

}
