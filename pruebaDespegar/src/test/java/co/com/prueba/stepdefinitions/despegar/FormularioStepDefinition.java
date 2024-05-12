package co.com.prueba.stepdefinitions.despegar;

import co.com.prueba.model.FormularioModel;
import co.com.prueba.page.despegar.FormularioPage;
import co.com.prueba.page.despegar.PageFactoryFormulario;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.prueba.util.Util.crearUsuario;

public class FormularioStepDefinition extends WebSetup {

    PageFactoryFormulario pageFactoryFormulario;
    FormularioPage formularioPage;
    FormularioModel formularioModel;

    @Given("que el usuario esta en la pagina de registro")
    public void queElUsuarioEstaEnLaPaginaDeRegistro() {
       // generalSetup();
        pageFactoryFormulario = new PageFactoryFormulario(driver);
    }

    @When("ingresa su informacion correctamente")
    public void ingresaSuInformacionCorrectamente() {
        formularioModel = crearUsuario();
        formularioPage = new FormularioPage(driver, formularioModel);
        pageFactoryFormulario.llenarFomu();
        System.out.println("Estoy en el test 1");
    }

    @When("envia el formulario")
    public void enviaElFormulario() throws InterruptedException {
       // formularioPage.enviarFormulario();
        Thread.sleep(5000);
    }

    @Then("deberia observar un mensaje de registro exitoso")
    public void deberiaObservarUnMensajeDeRegistroExitoso() {
        //Assertions.assertEquals(MENSAJE_ESPERADO, formularioPage.obtenerMensajeBienvenida());
       // quiteDriver();
    }

}
