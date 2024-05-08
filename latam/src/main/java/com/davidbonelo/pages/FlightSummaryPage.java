package com.davidbonelo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class FlightSummaryPage extends BasePage {
    @FindBy(id = "button9")
    WebElement seatsBtn;

    public FlightSummaryPage(WebDriver driver) {
        super(driver);
    }

    public SeatsPage navigateToSeatsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOf(seatsBtn)).click();
        return new SeatsPage(driver);
    }
}
