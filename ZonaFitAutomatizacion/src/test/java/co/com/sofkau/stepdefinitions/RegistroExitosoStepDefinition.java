package co.com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import co.com.sofkau.page.FormularioRegistroPage;
import co.com.sofkau.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static co.com.sofkau.util.constant.ConstantesMensajeConfirmacion.MENSAJE_ESPERADO_DE_REGISTRO;

public class RegistroExitosoStepDefinition extends WebSetup{
    FormularioRegistroPage formularioRegistroPage;
    Faker faker = new Faker();

    @Given("que el usuario selecciona el navegador {int} e ingresa a la pagina principal")
    public void queElUsuarioSeleccionaElNavegadorEIngresaALaPagina(Integer tipoDriver) {
        try{
            generalSetUp(tipoDriver);
        } catch (Exception e){
            System.out.println("Error al seleccionar el navegador: " + e.getMessage());
            e.printStackTrace();
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("ingresa su informacion correctamente")
    public void ingresaSuInformacionCorrectamente() {
        try {
            // Generar datos aleatorios
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();
            String confirmPassword = password;

            // Crear una instancia de la página de registro
            formularioRegistroPage = new FormularioRegistroPage(driver);

            // Llamar al método llenarFormulario con los valores
            formularioRegistroPage.llenarFormularioRegistro(email, password, confirmPassword);

        } catch (Exception e) {
            System.out.println("Error al ingresar informacion correctamente: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail();
            quiteDriver();
        }
    }
    @Then("deberia ser redirigido a la pagina principal con la sesion iniciada")
    public void deberiaSerRedirigidoALaPaginaPrincipalConLaSesionIniciada() {
        try{
            Assertions.assertNotNull(formularioRegistroPage);
            Assertions.assertEquals(MENSAJE_ESPERADO_DE_REGISTRO, formularioRegistroPage.obtenerMensajeDeIngreso());
        }catch (Exception e){
            System.out.println("Error al ser redirigido a la pagina principal: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail();
        }finally {
            quiteDriver();
        }
    }
}
