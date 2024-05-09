package com.davidbonelo;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Utils {
    private Utils() {
        throw new IllegalStateException("Utility Class");
    }

    public static void setupEnvVariables() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }

    public static RequestSpecification prepareCurrencyRequest() {
        return given().contentType(ContentType.JSON).header("x-cg-demo-api-key",
                System.getProperty("COINGECKO_API_KEY"));
    }

    public static <T> T pickRandomItem(List<T> list) {
        int randomIdx = (int) Math.floor(Math.random() * list.size());
        return list.get(randomIdx);
    }
}
