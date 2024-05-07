package co.com.sofkau.page.function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistroPage extends FunctionCommon{
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Acceder / Registrarse')]")
    private WebElement ACCEDER_REGISTRARSE;
    @CacheLookup
    @FindBy(xpath = "//input[@autocomplete=\"email\"]")
    private WebElement CAMPO_EMAIL;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"reg_password\"]")
    private WebElement CAMPO_PASSWORD;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"password_confirm\"]")
    private WebElement CAMPO_CONFIRM_PASSWORD;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/div/form/p[5]/button")
    private WebElement BOTON_REGISTRARSE;
    @CacheLookup
    @FindBy(xpath = "//span[@class=\"header-account-title\"]")
    private WebElement MENSAJE_DE_REGISTRO;


    //Constructor
    public RegistroPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Funciones
    public void llenarFormulario(String email, String password, String confirmPassword){
        tiempoDeEspera(); // Aplicar espera implícita antes de cada interacción

        clickSelection(ACCEDER_REGISTRARSE);
        scrollTo(CAMPO_EMAIL);
        typeInto(CAMPO_EMAIL, email);
        typeInto(CAMPO_PASSWORD, password);
        typeInto(CAMPO_CONFIRM_PASSWORD, confirmPassword);
        clickSelection(BOTON_REGISTRARSE);
    }

    public String obtenerMensajeDeIngreso(){
        return getText(MENSAJE_DE_REGISTRO);
    }



}
