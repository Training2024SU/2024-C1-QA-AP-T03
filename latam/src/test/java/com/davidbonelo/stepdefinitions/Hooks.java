package com.davidbonelo.stepdefinitions;

import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private final WebSetup webSetup;

    public Hooks(WebSetup webSetup) {
        this.webSetup = webSetup;
    }

//    @Before("@web")
//    public void setupWebDriver() {
//        webSetup.setupDriver();
//    }

    @After("@web")
    public void webDriverTearDown() {
        webSetup.quitDriver();
    }
}
