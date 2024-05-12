package co.com.prueba.page.despegar;

import co.com.prueba.model.FormularioModel;
import co.com.prueba.page.functions.FunctionCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class FormularioPage extends FunctionCommons {

    private FormularioModel usuario;

    private final By CAMPO_FORMULARIO = By.xpath("//h5[text()='Forms']");
    private final By CAMPO_FORMULARIO_ESPECIFICO = By.xpath("//span[text()='Practice Form']");
    private final By CAMPO_NOMBRE = By.id("firstName");
    private final By CAMPO_APELLIDO = By.id("lastName");
    private final By CORREO = By.id("userEmail");
    private final By CAMPO_GENERO = By.cssSelector("label[for='gender-radio-1']");
    private final By CAMPO_NUMERO = By.id("userNumber");
    private final By CAMPO_FECHA = By.className("react-datepicker-wrapper");
    private final By ANIOS = By.className("react-datepicker__year-select");
    private final By MESES = By.className("react-datepicker__month-select");
    private final String DIAS = ".react-datepicker__day--0%s";
    private final By CAMPO_SUBJECTS = By.id("subjectsInput");
    private final By CAMPO_HOBBIES = By.xpath("//label[@for='hobbies-checkbox-1']");
    private final By CAMPO_DIRECCION = By.id("currentAddress");
    private final By CAMPO_STATE = By.id("state");
    private final By ELECCION_STATE = By.xpath("//div[text()='NCR']");
    private final By CAMPO_CITY = By.id("city");
    private final By ELECCION_CITY = By.xpath("//div[text()='Delhi']");
    private final By BOTON_SUBMIT = By.id("submit");
    private final By MENSAJE_GRACIAS = By.id("example-modal-sizes-title-lg");


    public FormularioPage(WebDriver driver, FormularioModel usuario) {
        super(driver);
        this.usuario = usuario;
    }

    public void llenarFormulario() {
        scrollTo(CAMPO_FORMULARIO);
        clickSelection(CAMPO_FORMULARIO);
        clickSelection(CAMPO_FORMULARIO_ESPECIFICO);
        typeInto(CAMPO_NOMBRE, usuario.getNombre());
        typeInto(CAMPO_APELLIDO, usuario.getApellido());
        typeInto(CORREO, usuario.getCorreo());
        scrollTo(CAMPO_GENERO);
        clickSelection(CAMPO_GENERO);
        typeInto(CAMPO_NUMERO, usuario.getNumeroCelular());
        clickSelection(CAMPO_FECHA);
        selectOption(ANIOS, String.valueOf(anioAleatorio()));
        selectOption(MESES, String.valueOf(mesAleatorio()));
        clickSelection(By.cssSelector(String.format(DIAS, diaAleatorio())));
        scrollTo(CAMPO_SUBJECTS);
        typeInto(CAMPO_SUBJECTS, "English");
        driver.findElement(CAMPO_SUBJECTS).sendKeys(Keys.ENTER);
        clickSelection(CAMPO_HOBBIES);
        typeInto(CAMPO_DIRECCION, usuario.                                                                                                                                                                                                                                                                                               getDireccion());
        scrollTo(CAMPO_STATE);
        clickSelection(CAMPO_STATE);
        clickSelection(ELECCION_STATE);
        clickSelection(CAMPO_CITY);
        clickSelection(ELECCION_CITY);
        scrollTo(BOTON_SUBMIT);
    }

    public void enviarFormulario() {
        clickSelection(BOTON_SUBMIT);
    }

    public String obtenerMensajeBienvenida() {
        return getText(MENSAJE_GRACIAS);
    }

}
