package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends BasePage {
    private final By payBtnLocator = By.id("paymentCTA");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String getTotalCost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payBtnLocator)).getText();
    }
}
