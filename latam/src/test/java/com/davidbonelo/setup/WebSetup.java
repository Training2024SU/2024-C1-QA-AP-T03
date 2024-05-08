package com.davidbonelo.setup;

import org.openqa.selenium.WebDriver;

import static com.davidbonelo.setup.BrowserSetup.getBrowserDriver;

public class WebSetup {

    public static final String BASE_URL = "https://www.latamairlines.com/co/es";
    public WebDriver driver;

    public WebSetup() {
    }

    public void setupDriver(BrowserType browserType) {
        driver = getBrowserDriver(browserType);
        maximize();
        driver.get(BASE_URL);
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
