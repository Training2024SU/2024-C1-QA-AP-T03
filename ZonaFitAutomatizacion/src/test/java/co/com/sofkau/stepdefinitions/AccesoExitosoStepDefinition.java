package co.com.sofkau.stepdefinitions;

import co.com.sofkau.page.FormularioAccesoPage;
import co.com.sofkau.page.FormularioRegistroPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.Constantes.MENSAJE_ESPERADO_DE_ACCESO;


public class AccesoExitosoStepDefinition extends WebSetup {
    FormularioAccesoPage formularioAccesoPage;
    FormularioRegistroPage formularioRegistroPage;
    @When("ingresa sus datos de usuario registrado, correctamente")
    public void ingresaSusDatosDeUsuarioRegistrado(){
        try {
            // Generar datos existentes
            String emailRegistrado = "prueba@correo.com";
            String passwordUsuario = "prueba123";

            // Crear una instancia de la página de acceso

            formularioAccesoPage = new FormularioAccesoPage(driver);

            // Llamar al método llenarFormulario con los valores
            formularioAccesoPage.llenarFormularioAcceso(emailRegistrado, passwordUsuario);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("deberia ser redirigido a la pagina principal y le debe figurar la sesion iniciada")
    public void deberiaSerRedirigidoAlaPaginaPrincipalConLaSesionIniciada(){
        try{
            Assertions.assertNotNull(formularioAccesoPage);
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_ACCESO, formularioRegistroPage.obtenerMensajeDeIngreso());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            quiteDriver();
        }
    }
}

