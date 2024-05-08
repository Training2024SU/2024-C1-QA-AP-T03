package com.davidbonelo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomizePage extends BasePage {
    @FindBy(css = ".amount")
    WebElement finalPrice;

    public CustomizePage(WebDriver driver) {
        super(driver);
    }

    public String getFinalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(finalPrice)).getText();
    }
}
