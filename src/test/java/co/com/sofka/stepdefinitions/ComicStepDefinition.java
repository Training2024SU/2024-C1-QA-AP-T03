package co.com.sofka.stepdefinitions;

import co.com.sofka.ApiRest.getApis.ComicGetApi;
import co.com.sofka.model.ComicModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.jsonparser.JsonCommon.jsonToObject;
import static co.com.sofka.util.jsonparser.JsonCommon.toComic;

public class ComicStepDefinition {

    ComicGetApi comicGetApi;

    ComicModel comic;

    @Given("que el usuario tiene acceso a la API Marvel")
    public void queElUsuarioTieneAccesoALaAPIDeMarvel() {
        try {
            System.out.println("Autenticacion");

        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @When("realiza una solicitud GET para buscar el cómic con el ID {int}")
    public void realizaUnaSolicitudGETParaBuscarElCómicConElID(Integer idComic) {
        try {
            comicGetApi = new ComicGetApi(idComic);
            comicGetApi.setGetRequest();
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @Then("la respuesta debería tener un código de estado {int}")
    public void laRespuestaDeberíaTenerElCódigoDeEstado(Integer codEstado) {
        try {
            Assertions.assertEquals(codEstado, comicGetApi.getStatusCode(), "Se valida código de respuesta 200");
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @Then("la respuesta debería incluir la información correcta del comic con título {string} y ID {int}")
    public void laRespuestaDeberíaIncluirLaInformaciónCorrectaDelCómicConTítuloYID(String titulo, int idComic) {
        try {
            // Valida empty
            Assertions.assertFalse(comicGetApi.responseToString().isEmpty());

            // JSONObject de la libreria json.simple con la informacion del cómic
            JSONObject comicObject = jsonToObject(comicGetApi.responseToString());

            comic = toComic(comicObject);

            // validar que el body de la respuesta corresponda al cómic indicado
            Assertions.assertEquals(idComic, comic.getId());

            // Validar el título del cómic
            Assertions.assertEquals(titulo, comic.getTitle());

            // Validar que se tenga la información adicional del cómic
            Assertions.assertNotNull(comic.getDescription());
            Assertions.assertNotNull(comic.getFormat());
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @Then("la respuesta debería tener un codigo ISBN {string} asociado")
    public void laRespuestaDeberíaTenerUnCodigoISBNAsociado(String isbn) {
        try {
            // Validar el código ISBN del cómic
            Assertions.assertEquals(isbn, comic.getIsbn());
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
}
