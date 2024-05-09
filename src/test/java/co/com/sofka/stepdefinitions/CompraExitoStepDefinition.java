package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompraExitoStepDefinition {
    @Given("que el usuario está en la página de inicio del Éxito desde el navegador {string}")
    public void queElUsuarioEstáEnLaPáginaDeInicioDelÉxito(String navegador) {
        try {
            System.out.println("Autenticacion");

        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
    @When("el usuario elige un producto en promoción y lo agrega al carrito")
    public void elUsuarioEligeUnProductoEnPromociónYLoAgregaAlCarrito() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("el usuario indica la cantidad del producto y llena formulario de informacion personal")
    public void elUsuarioIndicaLaCantidadDelProductoYLlenaFormularioDeInformacionPersonal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("selecciona la opción de envío {string}")
    public void seleccionaLaOpciónDeEnvío(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("completa la información de pago")
    public void completaLaInformaciónDePago() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("se debería mostrar un mensaje de confirmación de la compra")
    public void seDeberíaMostrarUnMensajeDeConfirmaciónDeLaCompra() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
