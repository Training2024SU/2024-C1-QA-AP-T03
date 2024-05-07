package co.com.sofkau.stepdefinitions;


import co.com.sofkau.page.function.RegistroPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.Constantes.MENSAJE_ESPERADO_DE_REGISTRO;

public class RegistroStepDefinition extends WebSetup{
    RegistroPage registroPage;

    @Given("que el usuario selecciona el navegador {int} e ingresa a la pagina")
    public void queElUsuarioSeleccionaElNavegadorEIngresaALaPagina(Integer tipoDriver) {
        try{
            generalSetUp(tipoDriver);
        } catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }

    @When("ingresa su informacion correctamente con su email {string}, password {string}, confirma su password {string}")
    public void ingresaSuInformacionCorrectamente(String email, String password, String confirmPassword) {
        try {
            // Crear una instancia de la página de registro
            registroPage = new RegistroPage(driver);

            // Llamar al método llenarFormulario con los valores recuperados del escenario
            registroPage.llenarFormulario(email, password, confirmPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
        }
    }

    @When("envia el registro")
    public void enviaElRegistro() {

    }

    @Then("deberia ser redirigido a la pagina principal con la sesion iniciada")
    public void deberiaSerRedirigidoALaPaginaPrincipalConLaSesionIniciada() {
        try{
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_REGISTRO, registroPage.obtenerMensajeDeIngreso());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            quiteDriver();
        }
    }
}
