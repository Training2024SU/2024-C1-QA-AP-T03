package co.com.sofka.stepdefinitions;

import co.com.sofka.page.TableroSorteablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.setup.UrlLibrary.URL_TABLERO_SORTEABLE;
import static org.junit.Assert.assertNotEquals;

public class TableroStepDefinition extends WebSetup {

    TableroSorteablePage tableroSorteablePage;

    @Given("que el usuario esta en la página de interacción")
    public void queElUsuarioEstaEnLaPáginaDeInteracción() {
        try {
            generalSetUp(3,URL_TABLERO_SORTEABLE);
            tableroSorteablePage = new TableroSorteablePage(driver);
            tableroSorteablePage.obtenerElemementos();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }

    }

    @When("organiza su lista deslizando los items")
    public void organizaSuLista() {
        try {
            tableroSorteablePage.organizarElemetos();
            tableroSorteablePage.obtenerElementosOrganizados();
            System.out.println("Organizar lista");
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }

    }

    @Then("los elementos de la lista deberían estar organizados según el orden dado por el usuario")
    public void losElementosDeLaListaDeberíanEstarSegunElOrdenDelUsuario() {
        try {

            // Verificar si los elementos están organizados correctamente
            Assertions.assertTrue(tableroSorteablePage.compararListas());

        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }finally {
            quiteDriver();
        }

    }

}
