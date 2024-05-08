package co.com.sofka.stepdefinitions;

import co.com.sofka.model.FormularioModel;
import co.com.sofka.page.FormularioPage;
import co.com.sofka.page.FormularioPageFactory;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_REGISTRO_FORM;
import static co.com.sofka.stepdefinitions.ConstantesEjecucion.MSN_GRACIAS;
import static co.com.sofka.util.util.crearUsuario;


public class FormularioStepDefinition extends WebSetup {

    FormularioPage formularioPage;

    FormularioPageFactory formularioPageFactory;
    FormularioModel formularioModel;

    @Given("que el usuario esta en la pagina de registro")
    public void queElUsuarioEstaEnLaPaginaDeRegistro() {
        try {
            generalSetUp(2,URL_REGISTRO_FORM);
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }

    @When("ingresa su informacion correctamente")
    public void ingresaSuInformacionCorrectamente() {
        try {
            formularioModel = crearUsuario();
            formularioPageFactory = new FormularioPageFactory(driver,formularioModel);
            formularioPageFactory.llenarFormulario();
           /* formularioPage =  new FormularioPage(driver,formularioModel);
            formularioPage.llenarFormulario();*/
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }

    @When("envia el formulario")
    public void enviaElFormulario() throws InterruptedException {
        try {
//            formularioPage.enviarFormulario();
            formularioPageFactory.enviarFormulario();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }

    }

    @Then("deberia observar un mensaje de registro exitoso")
    public void deberiaObservarUnMensajeDeRegistroExitoso() throws InterruptedException {
        try {
            Assertions.assertEquals(MSN_GRACIAS,formularioPageFactory.mensajeBienvenida());
            Assertions.assertTrue(formularioPageFactory.compararRegistro());
           /* Assertions.assertEquals(MSN_GRACIAS,formularioPage.mensajeBienvenida());
            Assertions.assertTrue(formularioPage.compararRegistro());*/
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
//          Thread.sleep(5000);
            quiteDriver();
        }

    }
}
