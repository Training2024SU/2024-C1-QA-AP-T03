package com.davidbonelo.stepdefinitions;

import com.davidbonelo.ApiEndpoints;
import com.davidbonelo.Utils;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Hooks {

    private final WebSetup webSetup;

    public Hooks(WebSetup webSetup) {
        this.webSetup = webSetup;
    }

//    @Before("@web")
//    public void setupWebDriver() {
//        webSetup.setupDriver(BrowserType.CHROME);
//    }

    @BeforeAll
    public static void setup() {
        Utils.setupEnvVariables();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @After("@web")
    public void webDriverTearDown() {
        webSetup.quitDriver();
    }

    @Before("@currency")
    public void currencyUrlSetup() {
        RestAssured.baseURI = ApiEndpoints.COINGECKO_BASE;
        RestAssured.basePath = ApiEndpoints.SIMPLE_PATH;
    }
}
