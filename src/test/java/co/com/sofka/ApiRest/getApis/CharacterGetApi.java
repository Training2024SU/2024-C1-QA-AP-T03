package co.com.sofka.ApiRest.getApis;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static co.com.sofka.ApiRest.configurationRequest.Services.CHARACTER_FIND_ID;
import static co.com.sofka.ApiRest.configurationRequest.ParamsConfig.*;
import static io.restassured.RestAssured.given;

public class CharacterGetApi {

    private Response response;
    private int character;

    public CharacterGetApi(int character) {
        this.character = character;
    }

    public void setGetRequest(){
        // Hacer la solicitud a la API de Marvel
        Response res = RestAssured.given()
                .params(TS, timestamp,API_KEY, publicKey,HASH, hash, ID, character)
                .get(baseUrl+CHARACTER_FIND_ID);
        response = res;
    }

    public int getStatusCode(){
        return response.then().extract().statusCode();
    }

    public String responseToString(){
        return response.asString();
    }

}
