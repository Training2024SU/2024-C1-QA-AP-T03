package co.com.sofkau.stepdefinitions;

import co.com.sofkau.page.FormularioAccesoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import co.com.sofkau.setup.WebSetup;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.ConstantesMensajeConfirmacion.MENSAJE_ESPERADO_DE_ACCESO_INCORRECTO_CUENTA_NO_EXISTENTE;

public class AccesoNoExitosoCuentaNoExistenteSD extends WebSetup {
    Faker faker = new Faker();
    FormularioAccesoPage formularioAccesoPage;
    @When("ingresa sus datos pero no se ha registrado")
    public void ingresaSusDatosPeroNoSeHaRegistrado(){
        try {
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();

            // Crear una instancia de la página de acceso

            formularioAccesoPage = new FormularioAccesoPage(driver);

            // Llamar al método llenarFormulario con los valores
            formularioAccesoPage.llenarFormularioAcceso(email, password);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Then("deberia visualizar un mensaje de error y no deberia iniciarse su sesion")
    public void deberiaVisualizarUnMensajeDeError(){
        try{
            Assertions.assertNotNull(formularioAccesoPage);
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_ACCESO_INCORRECTO_CUENTA_NO_EXISTENTE, formularioAccesoPage.obtenerMensajeDeAccesoIncorrectoCuentaNoExistente());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            quiteDriver();
        }
    }
}
