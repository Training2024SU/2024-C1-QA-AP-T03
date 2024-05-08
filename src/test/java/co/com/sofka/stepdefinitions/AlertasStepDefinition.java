package co.com.sofka.stepdefinitions;

import co.com.sofka.page.AlertaPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_ALERTAS;
import static co.com.sofka.stepdefinitions.ConstantesEjecucion.MSN_ALERT_NOMBRE;


public class AlertasStepDefinition extends WebSetup {

    private AlertaPage alertaPage;


    @Given("que el usuario esta en la página de alertas")
    public void queElUsuarioEstaEnLaPáginaDeAlertas() {
        try {
            generalSetUp(1,URL_ALERTAS);
            alertaPage = new AlertaPage(driver);
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("el usuario realiza acciones que generan alertas")
    public void usuarioGeneraAccionesQueGeneranAlertas() {
        try {
            System.out.println("El usuario realiza acciones que generan alertas");
            alertaPage.dispararAlerta();
            alertaPage.dispararTimeAlert();
            alertaPage.dispararAlertCancelationButton();
            alertaPage.dispararPromtButton(MSN_ALERT_NOMBRE);
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("el sistema debería alertar al usuario")
    public void elSistemaDeberiaAlertarAlUsuario() {
        try {

            System.out.println("sistema alertando al usuario");
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            quiteDriver();
        }
    }

}
