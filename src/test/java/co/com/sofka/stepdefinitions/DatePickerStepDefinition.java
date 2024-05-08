package co.com.sofka.stepdefinitions;

import co.com.sofka.page.DatePickerPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_DATEPICKER;
import static co.com.sofka.util.util.crearFecha;

public class DatePickerStepDefinition extends WebSetup {

    private DatePickerPage datePickerPage;

    @Given("que el usuario esta en la página de datepicker")
    public void queElUsuarioEstaEnLaPáginaDeDatepicker() {
        try {
            generalSetUp(2,URL_DATEPICKER);
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario selecciona una fecha en el datepicker")
    public void elUsuarioSeleccionaUnaFechaEnElDatepicker() {
        try {
            datePickerPage = new DatePickerPage(driver,crearFecha());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }

    }
    @Then("la fecha seleccionada debería mostrarse correctamente en el campo correspondiente")
    public void laFechaSeleccionadaDeberíaMostrarseCorrectamenteEnElCampoCorrespondiente() throws InterruptedException {
        try {
            datePickerPage.llenarDatePicker();
            System.out.println("la fecha seleccionada debería mostrarse correctamente en el campo correspondiente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            Thread.sleep(10000);
            quiteDriver();
        }
    }
    @When("el usuario selecciona una fecha y hora en el datepicker")
    public void elUsuarioSeleccionaUnaFechaYHoraEnElDatepicker() {
        try {
            //Borar cuando se haga el test completo
            datePickerPage = new DatePickerPage(driver,crearFecha());
//            datePickerPage.setFecha(crearFecha());
            System.out.println("el usuario selecciona una fecha y hora en el datepicker");
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("la fecha y hora seleccionadas se muestran correctamente en el campo correspondiente")
    public void laFechaYHoraSeleccionadasSeMuestranCorrectamenteEnElCampoCorrespondiente() throws InterruptedException {
        try {
            datePickerPage.llenarDateTimePicker(crearFecha());
            System.out.println("la fecha y hora seleccionadas se muestran correctamente en el campo correspondiente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            Thread.sleep(10000);
            quiteDriver();
        }

    }
}
