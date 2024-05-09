package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomizePage extends BasePage {
    private final By confirmCartBtn = By.id("button-cart-confirm");
    private final By boardingContinueBtn = By.id("PRIORITY_BOARDING-continue-button");

    @FindBy(css = ".amount")
    private WebElement finalPrice;
    @FindBy(id = "BAGS-continue-button")
    private WebElement bagsContinueBtn;

    public CustomizePage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(bagsContinueBtn));
    }

    public String getFinalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(finalPrice)).getText();
    }

    public PassengersDataPage continueWithoutCustomizations() {
        bagsContinueBtn.click();
        try {
            clickElement(boardingContinueBtn);
        } catch (Exception ignored) {
        }
        clickElement(confirmCartBtn);
        return new PassengersDataPage(driver);
    }
}
