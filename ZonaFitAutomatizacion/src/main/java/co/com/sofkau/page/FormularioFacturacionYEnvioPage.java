package co.com.sofkau.page;

import co.com.sofkau.page.function.FunctionCommon;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FormularioFacturacionYEnvioPage extends FunctionCommon{
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


    public FormularioFacturacionYEnvioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void llenarFormularioFacturacionYEnvio(String numeroDocumento, String nombre, String apellido, String email, String direccion, String numeroCelular) {
            tiempoDeEspera(); // Aplicar espera implícita antes de cada interacción

            typeInto(CAMPO_NUMERO_DOCUMENTO, numeroDocumento);
            scrollTo(CAMPO_EMAIL);
            typeInto(CAMPO_EMAIL, email);
            typeInto(CAMPO_NOMBRE, nombre);
            typeInto(CAMPO_APELLIDO, apellido);
            seleccionarDepartamento("Choco");
            seleccionarCiudad("Lloro");
            typeInto(CAMPO_DIRECCION, direccion);
            typeInto(CAMPO_NUMERO_CELULAR, numeroCelular);

    }

    public void confirmarFacturacion(){
        esperarTerminosYCondicionesCarga();
        scrollTo(ACEPTAR_TERMINOS_Y_CONDICIONES);
        clickSelection(ACEPTAR_TERMINOS_Y_CONDICIONES);
        clickSelection(BOTON_DE_CONFIRMAR_ORDER);

    }
    private void seleccionarCiudad(String ciudad) {
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

    // Para generar números de celulares colombianos válidos
    public String generarNumeroCelularColombiano(Faker faker) {
        String[] prefixes = {"300", "301", "302", "303", "304", "305", "310", "311", "312", "313", "314", "315", "316", "317", "318", "320", "321", "322", "323", "350"}; // Prefijos de operadores colombianos
        String prefijosRandom = prefixes[faker.number().numberBetween(0, prefixes.length)];
        String number = faker.numerify("#######"); // 7 dígitos aleatorios

        return prefijosRandom + number;
    }
}
