package co.com.sofka.stepdefinitions.pagina;

import co.com.sofka.page.SortablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SortableStepDefinition extends WebSetup {

    @Given("que el usuario esta en la pagina de Sortable")
    public void queElUsuarioEstaEnLaPaginaDeSortable() {
        try {
            sortableSetUp();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }
    @When("selecciona y desplaza un item")
    public void seleccionaYDesplazaUnItem() throws InterruptedException {
        SortablePage sortablePage = new SortablePage(driver);
        sortablePage.moverElemento();
        Thread.sleep(5000);
    }
    @Then("reubicarse en la nueva posicion")
    public void reubicarseEnLaNuevaPosicion() {
        try {
            Thread.sleep(2000);
            //validarMovimiento();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }finally {
            quitDriver();
        }
    }
}
