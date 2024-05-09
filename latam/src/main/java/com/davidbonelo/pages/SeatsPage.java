package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeatsPage extends BasePage {
    @FindBy(css = "button[data-available='true']")
    List<WebElement> availableSeats;
    @FindBy(id = "btn-confirm-and-continue")
    WebElement confirmBtn;

    public SeatsPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfAllElements(availableSeats));
    }

    public void selectSeats(int quantity) {
        if (availableSeats.size() < quantity) {
            throw new IllegalArgumentException("There are not enough seats available");
        }
        for (int i = 0; i < quantity; i++) {
            availableSeats.get(i).click();
        }
        selectSeatsForSecondFlight(quantity);
    }

    private void selectSeatsForSecondFlight(int quantity) {
        try {
            clickElement(By.id("btn-next-flight"));
        } catch (Exception ignored) {
            return;
        }
        new SeatsPage(driver).selectSeats(quantity);
    }

    public CustomizePage confirmAndContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
        return new CustomizePage(driver);
    }
}
