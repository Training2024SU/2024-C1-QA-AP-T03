package co.com.sofkau.page;

import co.com.sofkau.model.FormularioFacturacionYEnvioModel;
import co.com.sofkau.page.function.FunctionCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class FormularioFacturacionYEnvioPage extends FunctionCommon{

    private FormularioFacturacionYEnvioModel usuario;

    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//*[@id='billing_myfield12']")
    private WebElement CAMPO_NUMERO_DOCUMENTO;
    @CacheLookup
    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement CAMPO_EMAIL;
    @CacheLookup
    @FindBy(xpath = "//*[@id='billing_first_name']")
    private WebElement CAMPO_NOMBRE;
    @CacheLookup
    @FindBy(xpath = "//*[@id='billing_last_name']")
    private WebElement CAMPO_APELLIDO;
    @CacheLookup
    @FindBy(xpath = "//span[@class = 'select2-search select2-search--dropdown']")
    private WebElement SELECCIONAR_CAMPO_DEPARTAMENTO;
    @CacheLookup
    @FindBy(xpath = "//*[@id='billing_state_field']/span")
    private WebElement SELECCIONAR_DEPARTAMENTO;
    @CacheLookup
    @FindBy(xpath = "//select[@id='billing_city']")
    private WebElement SELECCIONAR_CIUDAD;
    @CacheLookup
    @FindBy(xpath = "//*[@id='billing_address_1_field']//input")
    private WebElement CAMPO_DIRECCION;
    @CacheLookup
    @FindBy(xpath = "//*[@id='billing_phone']")
    private WebElement CAMPO_NUMERO_CELULAR;
    @CacheLookup
    @FindBy(xpath = "//*[@id='place_order']")
    private WebElement BOTON_REALIZAR_PEDIDO;
    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox' and @id='terms']")
    private WebElement ACEPTAR_TERMINOS_Y_CONDICIONES;
    @CacheLookup
    @FindBy(xpath = "//div[@class='blockUI blockOverlay']")
    private List<WebElement> CargandoTerminosYCondiciones;
    @CacheLookup
    @FindBy(xpath = "//button[@id='place_order']")
    private WebElement BOTON_DE_CONFIRMAR_ORDER;


    public FormularioFacturacionYEnvioPage(WebDriver driver, FormularioFacturacionYEnvioModel usuario) {
        super(driver);
        this.usuario = usuario;
        PageFactory.initElements(driver, this);
    }

    public void llenarFormularioFacturacionYEnvio() {
            tiempoDeEspera(); // Aplicar espera implícita antes de cada interacción

            typeInto(CAMPO_NUMERO_DOCUMENTO, usuario.getNumeroDocumento());
            scrollTo(CAMPO_EMAIL);
            typeInto(CAMPO_EMAIL, usuario.getEmail());
            typeInto(CAMPO_NOMBRE, usuario.getNombre());
            typeInto(CAMPO_APELLIDO, usuario.getApellido());
            seleccionarDepartamento("Choco");
            seleccionarCiudad("Lloro");
            scrollTo(CAMPO_DIRECCION);
            typeInto(CAMPO_DIRECCION, usuario.getDireccion());
            typeInto(CAMPO_NUMERO_CELULAR, usuario.getNumeroCelular());

    }

    public void confirmarFacturacion(){
        esperarTerminosYCondicionesCarga();
        scrollTo(ACEPTAR_TERMINOS_Y_CONDICIONES);
        clickSelection(ACEPTAR_TERMINOS_Y_CONDICIONES);
        clickSelection(BOTON_DE_CONFIRMAR_ORDER);

    }
    private void seleccionarCiudad(String ciudad) {
        scrollTo(SELECCIONAR_CIUDAD);
        clickSelection(SELECCIONAR_CIUDAD);

        typeInto(SELECCIONAR_CIUDAD, ciudad);
        typeEntryKey(SELECCIONAR_CIUDAD);

    }

    private void esperarTerminosYCondicionesCarga(){
        for(WebElement elementoBloqueo: CargandoTerminosYCondiciones){
            waitForElementInvisible(elementoBloqueo);
        }
    }

    private void seleccionarDepartamento(String departamento){
        scrollTo(SELECCIONAR_DEPARTAMENTO);

        clickSelection(SELECCIONAR_DEPARTAMENTO);

        WebElement buscadorDeDepartamento = driver.findElement(By.xpath("//input[@role='combobox']"));

        waitForElementVisible(buscadorDeDepartamento);
        clickSelection(buscadorDeDepartamento);

        typeInto(buscadorDeDepartamento, departamento);
        esperarAQueCarguenOpciones();

        WebElement opcionDeDepartamento = driver.findElement(By.xpath("//li[@role='option']"));
        waitForElementVisible(opcionDeDepartamento);

        clickSelection(opcionDeDepartamento);
        waitForElementInvisible(opcionDeDepartamento);
    }

    private int obtenerNumeroDeOpciones(){
        List<WebElement> departamentosDisponibles = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        return departamentosDisponibles.size();
    }

    private void esperarAQueCarguenOpciones(){
        int numeroDeDepartamentos = 0;
        int contador = 0;

        while(numeroDeDepartamentos < 1 && contador < 1000 ){
            numeroDeDepartamentos = obtenerNumeroDeOpciones();
            contador++;
        }
    }
}
