package co.com.sofkau.stepdefinitions;
import co.com.sofkau.page.RegistroPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.Constantes.MENSAJE_ESPERADO_DE_REGISTRO_INCORRECTO_CAMPO_VACIO;
import static co.com.sofkau.util.Constantes.MENSAJE_ESPERADO_DE_REGISTRO_INCORRECTO_CUENTA_EXISTENTE;

public class RegistroConCuentaExistenteSD extends WebSetup {
    RegistroPage registroPage;

    @When("ingresa sus datos correctamente pero ya esta registrado")
    public void ingresaSusDatosCorrectamenteYaEstaRegistrado() {
        try {
            // Generar datos existentes
            String email = "andreina@correo.com";
            String password = "andreina1234";
            String confirmPassword = password;

            // Crear una instancia de la página de registro

            registroPage = new RegistroPage(driver);

            // Llamar al método llenarFormulario con los valores
            registroPage.llenarFormulario(email, password, confirmPassword);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Then ("deberia visualizar un mensaje de error indicando que ya hay una cuenta registrada con dicho correo")
    public void deberiaVisualizarMensajeDeError(){
        try{
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_REGISTRO_INCORRECTO_CUENTA_EXISTENTE, registroPage.obtenerMensajeDeRegistroIncorrectoCuentaExistente());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            quiteDriver();
        }

    }
}
