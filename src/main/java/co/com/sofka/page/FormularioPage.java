package co.com.sofka.page;

import co.com.sofka.model.FormularioModel;
import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Month;
import java.util.Date;

import static co.com.sofka.util.util.*;

public class FormularioPage extends FunctionsCommon {

    // localizadores
    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement CAMPO_NOMBRE_2;

    private final By CAMPO_NOMBRE = By.id("firstName");
    private final By CAMPO_APELLIDO = By.id("lastName");
    private final By CAMPO_GENERO = By.cssSelector("label[for='gender-radio-1']");

    private final By Campo_Hobbies_sports =  By.cssSelector("label[for='hobbies-checkbox-1']");
    private final By CAMPO_NUMERO= By.id("userNumber");
    private final By CAMPO_EMAIL = By.id("userEmail");

    private final By CAMPO_BIRTH = By.id("dateOfBirthInput");
    private final By CAMPO_YEAR = By.className("react-datepicker__year-select");
    private final By CAMPO_MONTH = By.className("react-datepicker__month-select");

    private final By CAMPO_SUBJECTS = By.id("subjectsInput");

    private final By CAMPO_ADRESS = By.id("currentAddress");

    private final By CAMPO_STATE = By.id("state");
    private final By INPUT_STATE = By.id("react-select-3-input");

    private final By CAMPO_CITY = By.id("city");

    private final By INPUT_CITY = By.id("react-select-4-input");



    private final By BOTON_SUBMIT = By.id("submit");
    private final By MENSAJE_CONFIRMACION = By.id("example-modal-sizes-title-lg");

    private final By RESULT_STUDENT_NAME = By.xpath("//tr[td[text()='Student Name']]/td[2]");
    private final By RESULT_STUDENT_EMAIL = By.xpath("//tr[td[text()='Student Email']]/td[2]");
    private final By RESULT_GENDER = By.xpath("//tr[td[text()='Gender']]/td[2]");
    private final By RESULT_MOBILE = By.xpath("//tr[td[text()='Mobile']]/td[2]");
    private final By RESULT_DATE_OF_BIRTH = By.xpath("//tr[td[text()='Date of Birth']]/td[2]");
    private final By RESULT_SUBJECTS = By.xpath("//tr[td[text()='Subjects']]/td[2]");
    private final By RESULT_HOBBIES = By.xpath("//tr[td[text()='Hobbies']]/td[2]");
    private final By RESULT_ADDRESS = By.xpath("//tr[td[text()='Address']]/td[2]");
    private final By RESULT_STATE_AND_CITY = By.xpath("//tr[td[text()='State and City']]/td[2]");
    private FormularioModel usuario;

   private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public FormularioPage(WebDriver driver, FormularioModel usuario) {
        super(driver);
        this.usuario = usuario;
        PageFactory.initElements(driver,this);
    }

    // funciones

    public void llenarFormulario(){
        clearInput(CAMPO_BIRTH);
        typeInto(CAMPO_NOMBRE, usuario.getFirstName());
        typeInto(CAMPO_APELLIDO, usuario.getLastName());
        typeInto(CAMPO_EMAIL, usuario.getEmail());
        scrollTo(CAMPO_GENERO);
        clickSelection(CAMPO_GENERO);
        usuario.setGender(getText(CAMPO_GENERO));
        typeInto(CAMPO_NUMERO, usuario.getMobile());
        llenarDatePickBirth();
        llenarSubjects();
        clickSelection(Campo_Hobbies_sports);
        usuario.setHobbies(getText(Campo_Hobbies_sports));
        typeInto(CAMPO_ADRESS,usuario.getAddress());
        scrollTo(BOTON_SUBMIT);

    }

    private void llenarDatePickBirth(){
        clickSelection(CAMPO_BIRTH);
        clickSelection(CAMPO_YEAR);
        typeInto(CAMPO_YEAR,obtenerYear(usuario.getBirth()));
        clickSelection(CAMPO_YEAR);
        clickSelection(CAMPO_MONTH);
        typeInto(CAMPO_MONTH, obtenerNombreMes(usuario.getBirth()));
        clickSelection(CAMPO_MONTH);
        By locator_day = generateDinamicCampoDay(obtenerOrdinal(usuario.getBirth().getDate()),
                obtenerNombreMes(usuario.getBirth()),
                obtenerYear(usuario.getBirth()),
                obtenerDiaSemana(usuario.getBirth()));
        ewait.until(ExpectedConditions.elementToBeClickable(locator_day));
        clickSelection(locator_day);
        llenarStateCity();
    }

    private void llenarSubjects(){
        clickSelection(CAMPO_SUBJECTS);
        for (String subject:usuario.getSubjects()) {
            ewait.until(ExpectedConditions.elementToBeClickable(CAMPO_SUBJECTS));
             typeInto(CAMPO_SUBJECTS,subject);
             typeKey(CAMPO_SUBJECTS,Keys.ENTER);
        }
    }

    private void llenarStateCity(){
        clickSelection(CAMPO_STATE);
        typeInto(INPUT_STATE,usuario.getState());
        typeKey(INPUT_STATE, Keys.ENTER);
        clickSelection(CAMPO_CITY);
        typeInto(INPUT_CITY,usuario.getCity());
        typeKey(INPUT_CITY, Keys.ENTER);
    }

    public void enviarFormulario(){
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        clickSelection(BOTON_SUBMIT);
    }

    public String mensajeBienvenida(){

        return getText(MENSAJE_CONFIRMACION);
    }

    private By generateDinamicCampoDay(String num,String month,String year,String day) {

        String selector = "div[aria-label='Choose "+day+", "+month+" "+num+", "+year+"']";

        return  By.cssSelector(selector);
    }

    public Boolean compararRegistro(){
        boolean comparacion = true;

        if(!(usuario.getFirstName()+" "+usuario.getLastName()).equals(getText(RESULT_STUDENT_NAME))){
            comparacion = false;
            System.out.println(getText(RESULT_STUDENT_NAME));
        }

        if(!usuario.getEmail().equals(getText(RESULT_STUDENT_EMAIL))){
            comparacion = false;
            System.out.println(getText(RESULT_STUDENT_EMAIL));
        }

        if(!usuario.getGender().equals(getText(RESULT_GENDER))){
            comparacion = false;
            System.out.println(getText(RESULT_GENDER));
        }

        if(!usuario.getMobile().equals(getText(RESULT_MOBILE))){
            comparacion = false;
            System.out.println(getText(RESULT_MOBILE));
        }


        if(!compararFechas(usuario.getBirth(),stringToDateResult(getText(RESULT_DATE_OF_BIRTH)))){
            comparacion = false;
        }

        if(!convertirArrayListACadena(usuario.getSubjects()).equals(getText(RESULT_SUBJECTS))){
            System.out.println(getText(RESULT_SUBJECTS));
            System.out.println(convertirArrayListACadena(usuario.getSubjects()));
            comparacion = false;
        }


        if(!usuario.getHobbies().equals(getText(RESULT_HOBBIES))){
            comparacion = false;
            System.out.println(getText(RESULT_HOBBIES));
        }

        if(!usuario.getAddress().equals(getText(RESULT_ADDRESS))){
            comparacion = false;
            System.out.println(getText(RESULT_ADDRESS));
        }

        if(!(usuario.getState()+" "+usuario.getCity()).equals(getText(RESULT_STATE_AND_CITY))){
            comparacion = false;
            System.out.println(getText(RESULT_STATE_AND_CITY));
        }

        return comparacion;
    }


}
