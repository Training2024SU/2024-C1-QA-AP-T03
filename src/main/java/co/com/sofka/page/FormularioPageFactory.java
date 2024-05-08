package co.com.sofka.page;

import co.com.sofka.model.FormularioModel;
import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static co.com.sofka.util.util.*;
import static co.com.sofka.util.util.convertirArrayListACadena;

public class FormularioPageFactory extends FunctionsCommon {

    // localizadores
    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement CAMPO_NOMBRE;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement CAMPO_APELLIDO;

    @CacheLookup
    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement CAMPO_GENERO;

    @CacheLookup
    @FindBy(css = "label[for='hobbies-checkbox-1']")
    private WebElement CAMPO_HOBBIES_SPORTS;

    @CacheLookup
    @FindBy(id = "userNumber")
    private WebElement CAMPO_NUMERO;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement CAMPO_EMAIL;

    @CacheLookup
    @FindBy(id = "dateOfBirthInput")
    private WebElement CAMPO_BIRTH;

    @CacheLookup
    @FindBy(className = "react-datepicker__year-select")
    private WebElement CAMPO_YEAR;

    @CacheLookup
    @FindBy(className = "react-datepicker__month-select")
    private WebElement CAMPO_MONTH;

    @CacheLookup
    @FindBy(id = "subjectsInput")
    private WebElement CAMPO_SUBJECTS;

    @CacheLookup
    @FindBy(id = "currentAddress")
    private WebElement CAMPO_ADDRESS;

    @CacheLookup
    @FindBy(id = "state")
    private WebElement CAMPO_STATE;

    @CacheLookup
    @FindBy(id = "react-select-3-input")
    private WebElement INPUT_STATE;

    @CacheLookup
    @FindBy(id = "city")
    private WebElement CAMPO_CITY;

    @CacheLookup
    @FindBy(id = "react-select-4-input")
    private WebElement INPUT_CITY;

    @CacheLookup
    @FindBy(id = "submit")
    private WebElement BOTON_SUBMIT;

    @CacheLookup
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement MENSAJE_CONFIRMACION;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Student Name']]/td[2]")
    private WebElement RESULT_STUDENT_NAME;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Student Email']]/td[2]")
    private WebElement RESULT_STUDENT_EMAIL;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Gender']]/td[2]")
    private WebElement RESULT_GENDER;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Mobile']]/td[2]")
    private WebElement RESULT_MOBILE;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Date of Birth']]/td[2]")
    private WebElement RESULT_DATE_OF_BIRTH;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Subjects']]/td[2]")
    private WebElement RESULT_SUBJECTS;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Hobbies']]/td[2]")
    private WebElement RESULT_HOBBIES;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='Address']]/td[2]")
    private WebElement RESULT_ADDRESS;

    @CacheLookup
    @FindBy(xpath = "//tr[td[text()='State and City']]/td[2]")
    private WebElement RESULT_STATE_AND_CITY;
    private FormularioModel usuario;

    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public FormularioPageFactory(WebDriver driver, FormularioModel usuario) {
        super(driver);
        this.usuario = usuario;
        PageFactory.initElements(driver,this);
    }

    public FormularioPageFactory(WebDriver driver) {
        super(driver);
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
        clickSelection(CAMPO_HOBBIES_SPORTS);
        usuario.setHobbies(getText(CAMPO_HOBBIES_SPORTS));
        typeInto(CAMPO_ADDRESS,usuario.getAddress());
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
            typeKey(CAMPO_SUBJECTS, Keys.ENTER);
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
