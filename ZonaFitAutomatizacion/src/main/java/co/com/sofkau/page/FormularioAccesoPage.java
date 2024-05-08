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
            clickSelection(BOTON_ACCEDER);
        } catch (Exception e) {
            System.out.println("Error al llenar el formulario de acceso: " + e.getMessage());
        }
    }
}
