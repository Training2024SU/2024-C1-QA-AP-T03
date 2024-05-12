package co.com.sofkau.stepdefinitions;
import co.com.sofkau.page.FormularioRegistroPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.constant.ConstantesMensajeConfirmacion.MENSAJE_ESPERADO_DE_REGISTRO_INCORRECTO_CUENTA_EXISTENTE;

public class RegistroConCuentaExistenteSD extends WebSetup {
    FormularioRegistroPage formularioRegistroPage;

    @When("ingresa sus datos correctamente pero ya esta registrado")
    public void ingresaSusDatosCorrectamenteYaEstaRegistrado() {
        try {
            // Generar datos existentes
            String email = "prueba@correo.com";
            String password = "prueba123";
            String confirmPassword = password;

            // Crear una instancia de la página de registro

            formularioRegistroPage = new FormularioRegistroPage(driver);

            // Llamar al método llenarFormulario con los valores
            formularioRegistroPage.llenarFormularioRegistro(email, password, confirmPassword);

        } catch (Exception e) {
            System.out.println("Error al ingresar sus datos: " + e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }
    }
   @Then ("deberia visualizar un mensaje de error indicando que ya hay una cuenta registrada")
    public void deberiaVisualizarMensajeDeError(){
        try{
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_REGISTRO_INCORRECTO_CUENTA_EXISTENTE, formularioRegistroPage.obtenerMensajeDeRegistroIncorrectoCuentaExistente());

        }catch (Exception e){
            System.out.println("Error al visualizar mensaje de error: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail();
        }finally {
            quiteDriver();
        }
    }
}
