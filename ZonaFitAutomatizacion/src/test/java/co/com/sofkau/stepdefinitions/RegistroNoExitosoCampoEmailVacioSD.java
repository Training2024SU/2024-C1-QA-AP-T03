package co.com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import co.com.sofkau.page.FormularioRegistroPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.Constantes.MENSAJE_ESPERADO_DE_REGISTRO_INCORRECTO_CAMPO_VACIO;


public class RegistroNoExitosoCampoEmailVacioSD extends WebSetup{
    Faker faker = new Faker();
    FormularioRegistroPage formularioRegistroPage;
    @When ("intenta registrarse con el campo de correo vacio")
        public void intentaRegistrarseConElCampoDeCorreoVacio(){
        try {
            // Generar datos aleatorios
            String email = "";
            String password = faker.internet().password();
            String confirmPassword = password;

            // Crear una instancia de la página de registro

            formularioRegistroPage = new FormularioRegistroPage(driver);

            // Llamar al método llenarFormulario con los valores
            formularioRegistroPage.llenarFormularioRegistro(email, password, confirmPassword);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Then ("deberia visualizar un mensaje de error")
    public void deberiaVisualizarMensajeDeError(){
        try{
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_REGISTRO_INCORRECTO_CAMPO_VACIO, formularioRegistroPage.obtenerMensajeDeRegistroIncorrectoCampoVacio());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            quiteDriver();
        }
    }
}

