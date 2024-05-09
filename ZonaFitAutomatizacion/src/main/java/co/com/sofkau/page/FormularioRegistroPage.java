package co.com.sofkau.page;

import co.com.sofkau.page.function.FunctionCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioRegistroPage extends FunctionCommon {
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Acceder / Registrarse')]")
    private WebElement ACCEDER_REGISTRARSE;

    @CacheLookup
    @FindBy(xpath = "//input[@autocomplete='email']")
    private WebElement CAMPO_EMAIL;

    @CacheLookup
    @FindBy(xpath = "//*[@id='reg_password']")
    private WebElement CAMPO_PASSWORD;

    @CacheLookup
    @FindBy(xpath = "//*[@id='password_confirm']")
    private WebElement CAMPO_CONFIRM_PASSWORD;
    @CacheLookup
    @FindBy(xpath = "//*[@id='customer_login']/div[2]/div/form/p[5]/button")
    private WebElement BOTON_REGISTRARSE;
    @CacheLookup
    @FindBy(xpath = "//*[@id='masthead']/div/div[4]/ul/li[2]/a/span")
    private WebElement MENSAJE_DE_REGISTRO;
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-container container alert-color medium-text-center']")
    private WebElement MENSAJE_DE_REGISTRO_INCORRECTO_CAMPO_VACIO;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'message-container container alert-color medium-text-center']")
    private WebElement MENSAJE_DE_REGISTRO_INCORRECTO_CUENTA_EXISTENTE;



    //Constructor
    public FormularioRegistroPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Funciones
    public void llenarFormularioRegistro(String email, String password, String confirmPassword) {
        try {
            tiempoDeEspera(); // Aplicar espera implícita antes de cada interacción

            clickSelection(ACCEDER_REGISTRARSE);

            scrollTo(CAMPO_EMAIL);
            typeInto(CAMPO_EMAIL, email);
            typeInto(CAMPO_PASSWORD, password);
            typeInto(CAMPO_CONFIRM_PASSWORD, confirmPassword);
            clickSelection(BOTON_REGISTRARSE);
        } catch (Exception e) {
            System.out.println("Error al llenar el formulario: " + e.getMessage());
        }
    }

    public String obtenerMensajeDeIngreso(){
        return getText(MENSAJE_DE_REGISTRO);
    }

    public String obtenerMensajeDeRegistroIncorrectoCampoVacio(){
        waitForGeneralPageLoad();
        waitForElementVisible(MENSAJE_DE_REGISTRO_INCORRECTO_CAMPO_VACIO);
        return getText(MENSAJE_DE_REGISTRO_INCORRECTO_CAMPO_VACIO);
    }

    public String obtenerMensajeDeRegistroIncorrectoCuentaExistente(){
        waitForGeneralPageLoad();
        waitForElementVisible(MENSAJE_DE_REGISTRO_INCORRECTO_CUENTA_EXISTENTE);
        return getText(MENSAJE_DE_REGISTRO_INCORRECTO_CUENTA_EXISTENTE);
    }
}
