package co.com.sofkau.page;

import co.com.sofkau.page.function.FunctionCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioAccesoPage extends FunctionCommon{
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Acceder / Registrarse')]")
    private WebElement ACCEDER_REGISTRARSE;
    @CacheLookup
    @FindBy(xpath = "//*[@id='username']")
    private WebElement CAMPO_EMAIL_REGISTRADO;

    @CacheLookup
    @FindBy(xpath = "//*[@id='password']")
    private WebElement CAMPO_PASSWORD_REGISTRADO;
    @CacheLookup
    @FindBy(xpath = "//button[@class = 'woocommerce-button button woocommerce-form-login__submit']")
    private WebElement BOTON_ACCEDER;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'message-container container alert-color medium-text-center']")
    private WebElement MENSAJE_DE_ACCESOO_INCORRECTO_CUENTA_NO_EXISTENTE;
    @CacheLookup
    @FindBy(xpath = "//div[@class ='message-container container alert-color medium-text-center']")
    private WebElement MENSAJE_DE_ACCESOO_INCORRECTO_CAMPO_VACIO;

    //Constructor
    public FormularioAccesoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void llenarFormularioAcceso(String emailRegistrado, String passwordUsuario) {
        try {
            tiempoDeEspera(); // Aplicar espera implícita antes de cada interacción

            clickSelection(ACCEDER_REGISTRARSE);
            scrollTo(CAMPO_EMAIL_REGISTRADO);
            typeInto(CAMPO_EMAIL_REGISTRADO, emailRegistrado);
            typeInto(CAMPO_PASSWORD_REGISTRADO, passwordUsuario);
            scrollTo(BOTON_ACCEDER);
            clickSelection(BOTON_ACCEDER);
        } catch (Exception e) {
            System.out.println("Error al llenar el formulario de acceso: " + e.getMessage());
        }
    }
    public String obtenerMensajeDeAccesoIncorrectoCuentaNoExistente(){
        waitForElementVisible(MENSAJE_DE_ACCESOO_INCORRECTO_CUENTA_NO_EXISTENTE);
        return getText(MENSAJE_DE_ACCESOO_INCORRECTO_CUENTA_NO_EXISTENTE);
    }
    public String obtenerMensajeDeAccesoIncorrectoCuentaCampoVacio(){
        waitForElementVisible(MENSAJE_DE_ACCESOO_INCORRECTO_CAMPO_VACIO);
        return getText(MENSAJE_DE_ACCESOO_INCORRECTO_CAMPO_VACIO);
    }
}
