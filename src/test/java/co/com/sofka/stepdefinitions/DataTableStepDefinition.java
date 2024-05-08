package co.com.sofka.stepdefinitions;

import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_DATEPICKER;

public class DataTableStepDefinition extends WebSetup {

        @Given("que el administrador se encuentra en la página de gestion de usuarios")
        public void queElAdministradorSeEncuentraEnLaPáginaDeGestionDeUsuarios() {
            try {
                System.out.println("@Given: que el administrador se encuentra en la página de gestion de usuarios");
                generalSetUp(2,URL_DATEPICKER);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            }
        }

        @When("el administrador llena el formulario de usuario")
        public void elAdministradorLlenaElFormularioDeUsuario() {
            try {
                System.out.println("@When: el administrador llena el formulario de usuario");
                // Aquí va el código para llenar el formulario de usuario
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            }
        }

        @Then("el administrador debería visualizar la información del usuario agregado")
        public void elAdministradorDeberíaVisualizarLaInformaciónDelUsuarioAgregado() throws InterruptedException {
            try {
                System.out.println("@Then: el administrador debería visualizar la información del usuario agregado");
                // Aquí va el código para verificar la visualización de la información del usuario agregado
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            } finally {
                Thread.sleep(10000);
                quiteDriver();
            }
        }

        @When("el administrador modifica la información del usuario")
        public void elAdministradorModificaLaInformaciónDelUsuario() {
            try {
                System.out.println("@When: el administrador modifica la información del usuario");
                // Aquí va el código para modificar la información del usuario
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            }
        }

        @Then("el administrador debería ver la información actualizada del usuario en la página de gestión de usuarios")
        public void elAdministradorDeberíaVerLaInformaciónActualizadaDelUsuarioEnLaPáginaDeGestiónDeUsuarios() throws InterruptedException {
            try {
                System.out.println("@Then: el administrador debería ver la información actualizada del usuario en la página de gestión de usuarios");
                // Aquí va el código para verificar la visualización de la información actualizada del usuario
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            } finally {
                Thread.sleep(10000);
                quiteDriver();
            }
        }

        @When("el administrador elimina un usuario")
        public void elAdministradorEliminaUnUsuario() {
            try {
                System.out.println("@When: el administrador elimina un usuario");
                // Aquí va el código para eliminar un usuario
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            }
        }

        @Then("el usuario debería ser eliminado del sistema correctamente")
        public void elUsuarioDeberíaSerEliminadoDelSistemaCorrectamente() throws InterruptedException {
            try {
                System.out.println("@Then: el usuario debería ser eliminado del sistema correctamente");
                // Aquí va el código para verificar que el usuario ha sido eliminado correctamente
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            } finally {
                Thread.sleep(10000);
                quiteDriver();
            }
        }

        @When("el administrador ingresa el nombre de un usuario en el campo de búsqueda")
        public void elAdministradorIngresaElNombreDeUnUsuarioEnElCampoDeBúsqueda() {
            try {
                System.out.println("@When: el administrador ingresa el nombre de un usuario en el campo de búsqueda");
                // Aquí va el código para ingresar el nombre de un usuario en el campo de búsqueda
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            }
        }

        @Then("se debería visualizar en la tabla solo los usuarios cuyo nombre coincida con la búsqueda")
        public void seDeberíaVisualizarEnLaTablaSoloLosUsuariosCuyoNombreCoincidaConLaBúsqueda() throws InterruptedException {
            try {
                System.out.println("@Then: se debería visualizar en la tabla solo los usuarios cuyo nombre coincida con la búsqueda");
                // Aquí va el código para verificar que se visualizan los usuarios cuyo nombre coincide con la búsqueda
            } catch (Exception e) {
                System.out.println(e.getMessage());
                quiteDriver();
                Assertions.fail();
            } finally {
                Thread.sleep(10000);
                quiteDriver();
            }
        }
    }


