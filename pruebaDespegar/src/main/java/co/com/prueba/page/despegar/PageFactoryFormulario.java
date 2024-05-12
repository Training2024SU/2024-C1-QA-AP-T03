package co.com.prueba.page.despegar;

import co.com.prueba.model.FormularioModel;
import co.com.prueba.page.functions.FunctionCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryFormulario extends FunctionCommons {

    FormularioModel usuario = new FormularioModel();
    @CacheLookup
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement CAMPO_FORMULARIO;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement CAMPO_FORMULARIO_ESPECIFICO;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement CAMPO_NOMBRE;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement CAMPO_APELLIDO;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement CAMPO_EMAIL;

    @CacheLookup
    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement CAMPO_GENERO;

    @CacheLookup
    @FindBy(id = "userNumber")
    private WebElement CAMPO_TELEFONO;

    @CacheLookup
    @FindBy(className = "react-datepicker-wrapper")
    private WebElement CAMPO_FECHA;

    @CacheLookup
    @FindBy(className = "react-datepicker__year-select")
    private WebElement CAMPO_ANIO;

    @CacheLookup
    @FindBy(className = "react-datepicker__month-select")
    private WebElement CAMPO_MES;

    @CacheLookup
    @FindBy(css = "div[class='react-datepicker__day react-datepicker__day--0%s']")
    private WebElement CAMPO_DIA;

    @CacheLookup
    @FindBy(id = "subjectsInput")
    private WebElement CAMPO_SUBJET;

    @CacheLookup
    @FindBy(id = "subjectsInput")
    private WebElement SUBJET;

    @CacheLookup
    @FindBy(xpath = "//div[text()='English']")
    private WebElement SELECTION;

    @CacheLookup
    @FindBy(xpath = "//label[text()='Sports']")
    private WebElement HOBBIES;

    @CacheLookup
    @FindBy(id = "currentAddress")
    private WebElement ADDRES;

    private final String DIAS = ".react-datepicker__day--0%s";


    public PageFactoryFormulario(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void llenarFomu(){
        scrollTo(CAMPO_FORMULARIO);
        clickSelection(CAMPO_FORMULARIO);
        clickSelection(CAMPO_FORMULARIO_ESPECIFICO);
        typeInto(CAMPO_NOMBRE,"Devon");
        typeInto(CAMPO_APELLIDO, "Alvarez");
        typeInto(CAMPO_EMAIL, "devon.alvarez@gmail.com");
        scrollTo(CAMPO_GENERO);
        clickSelection(CAMPO_GENERO);
        typeInto(CAMPO_TELEFONO, "3023620275");
        clickSelection(CAMPO_FECHA);
        selectOption(CAMPO_ANIO, String.valueOf(anioAleatorio()));
        selectOption(CAMPO_MES, String.valueOf(mesAleatorio()));
        clickSelection(By.cssSelector(String.format(DIAS, diaAleatorio())));
        scrollTo(CAMPO_SUBJET);
        clickSelection(CAMPO_SUBJET,"e");
        clickSelection(SELECTION);
        clickSelection(HOBBIES);
        typeInto(ADDRES, generarDireccion());
    }

    public static void llenarFormularioCompra(WebDriver driver, String nombre, String apellido, String correo, String telefono) {
        driver.findElement(By.id("yql9co0fcos4jbf37krb2n")).sendKeys(nombre);
        driver.findElement(By.id("ue812hbbzisgi4c5igh3hm")).sendKeys(apellido);
        driver.findElement(By.id("formData.contactData.mainEmailAddress")).sendKeys(correo);
        driver.findElement(By.id("formData.contactData.phones[0].number")).sendKeys(telefono);
        // Agrega más campos y datos según sea necesario
    }

}
