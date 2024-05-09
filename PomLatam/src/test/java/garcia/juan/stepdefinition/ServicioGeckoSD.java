package garcia.juan.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ServicioGeckoSD {

    private Response response;

    @Given("el usuario tiene acceso a la api")
    public void el_usuario_tiene_acceso_a_la_api() {

    }
    @When("hace una solicitud GET para obtener el precio de bitcoin")
    public void hago_una_solicitud_get_para_obtener_el_precio_de_bitcoin() {
        response=given().when().get("https://api.coingecko.com/api/v3/simple/" +
                "price?ids=bitcoin&vs_currencies=usd&include_market_cap=" +
                "true&include_24hr_vol=true&include_24hr_change=true");
    }
    @Then("la respuesta deberia incluir el precio actual de Bitcoin en dolares estadounidenses")
    public void la_respuesta_debe_incluir_el_precio_actual_de_bitcoin_en_dólares_estadounidenses() {
        response.then().log().all().statusCode(200);
    }

    @When("hace una solicitud GET para obtener el precio de Ethereum en euros")
    public void hace_una_solicitud_get_para_obtener_el_precio_de_ethereum_en_euros() {
        response = given().when().get("https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=eur");
    }
    @Then("la respuesta debería incluir el precio actual de Ethereum en euros")
    public void la_respuesta_debería_incluir_el_precio_actual_de_ethereum_en_euros() {
        response.then().log().all();
    }

    @Then("la respuesta debería incluir el precio actual de Ethereum")
    public void la_respuesta_debería_incluir_el_precio_actual_de_ethereum() {
        response.then().log().all();
    }

    @Then("deberia obtener un codigo de estatus {int}")
    public void deberia_obtener_un_codigo_de_estatus(Integer int1) {
        response.then().statusCode(int1);
    }


}
