package co.com.sofkau.stepdefinitions;

import co.com.sofkau.page.FormularioAccesoPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import static co.com.sofkau.util.constant.ConstantesMensajeConfirmacion.MENSAJE_ESPERADO_DE_ACCESO_INCORRECTO_CAMPO_VACIO;

public class AccesoNoExitosoCampoVacioSD extends WebSetup {
    FormularioAccesoPage formularioAccesoPage;
    @When("ingresa sus datos pero deja el campo del password vacio")
    public void ingresaSusDatosPeroDejaElCampoDelPasswordVacio(){
        try {
            // Generar datos existentes
            String emailRegistrado = "prueba@correo.com";
            String passwordUsuario = "";

            // Crear una instancia de la página de acceso
            formularioAccesoPage = new FormularioAccesoPage(driver);

            // Llamar al método llenarFormulario con los valores
            formularioAccesoPage.llenarFormularioAcceso(emailRegistrado, passwordUsuario);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("deberia recibir un mensaje de error y no deberia iniciarse su sesion")
    public void deberiaRecibirUnMensajeDeError(){
        try{
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_ACCESO_INCORRECTO_CAMPO_VACIO, formularioAccesoPage.
                    obtenerMensajeDeAccesoIncorrectoCuentaCampoVacio());
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            Assertions.fail();
        }finally {
            quiteDriver();
        }
    }
}
