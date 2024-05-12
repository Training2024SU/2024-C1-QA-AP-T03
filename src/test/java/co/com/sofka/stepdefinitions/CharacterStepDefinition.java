package co.com.sofka.stepdefinitions;

import co.com.sofka.ApiRest.getApis.CharacterGetApi;
import co.com.sofka.model.CharacterModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.jsonparser.JsonCommon.jsonToObject;
import static co.com.sofka.util.jsonparser.JsonCommon.toCharacter;

public class CharacterStepDefinition {

    CharacterGetApi characterGetApi;

    @Given("que el usuario tiene acceso a la API de Marvel")
    public void queElUsuarioTieneAccesoALaAPIDeMarvel() {
        try {
            System.out.println("Autenticacion");

        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
    @When("realiza una solicitud GET para buscar el personaje con el ID {int}")
    public void realizaUnaSolicitudGETParaBuscarElPersonajeConElID(Integer idCharacter) {
        try {
            characterGetApi = new CharacterGetApi(idCharacter);
            characterGetApi.setGetRequest();
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }

    }
    @Then("la respuesta debería tener el código de estado {int}")
    public void laRespuestaDeberíaTenerElCódigoDeEstado(Integer codEstado) {
        try {
            Assertions.assertEquals(codEstado,characterGetApi.getStatusCode(),"Se valida código de respuesta 200");
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }

    }
    @Then("la respuesta debería incluir la información correcta del personaje con nombre {string} personaje con ID {int}")
    public void laRespuestaDeberíaIncluirLaInformaciónDelPersonajeConIDId(String nombre ,int idCharacter) {
        try {
            // Valida empty
            Assertions.assertFalse(characterGetApi.responseToString().isEmpty());

            // JSONObject de la libreria json.simple con la informacion del usuario
            JSONObject characterObject = jsonToObject(characterGetApi.responseToString());

            CharacterModel character = toCharacter(characterObject);

            // validar que el body de la respuesta corresponda al persona indicado
            Assertions.assertEquals(idCharacter,character.getId());

            // Validar el nombre del perosnaje
            Assertions.assertEquals(nombre,character.getNombre());

            // Validar que se tenga la informacion adicional del personaje
            Assertions.assertNotNull(character.getCopyright());
            Assertions.assertNotNull(character.getDescripcion());

        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

}
