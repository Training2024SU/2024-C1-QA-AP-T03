package co.com.sofka.ApiRest.getApis;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static co.com.sofka.ApiRest.configurationRequest.ParamsConfig.*;
import static co.com.sofka.ApiRest.configurationRequest.Services.COMIC_FIND_ID;

public class ComicGetApi {
    private Response response;
    private int comicId;

    public ComicGetApi(int comicId) {
        this.comicId = comicId;
    }

    public void setGetRequest(){
        // Hacer la solicitud a la API de Marvel
        Response res = RestAssured.given()
                .params(TS, timestamp, API_KEY, publicKey, HASH, hash, ID, comicId)
                .get(baseUrl + COMIC_FIND_ID);
        response = res;
    }

    public int getStatusCode(){
        return response.then().extract().statusCode();
    }

    public String responseToString(){
        return response.asString();
    }
}
