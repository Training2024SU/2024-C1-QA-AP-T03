package com.davidbonelo.pages;

import com.davidbonelo.pages.components.FlightCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlightsResultPage extends BasePage {

    By flightCardsSelector = By.cssSelector("ol li > div:not([data-testid^='banner'])");
    List<FlightCard> flightCards;

    public FlightsResultPage(WebDriver driver) {
        super(driver);
        flightCards = loadFlightCards();
    }

    private List<FlightCard> loadFlightCards() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> cardsElements =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(flightCardsSelector));
        return cardsElements.stream().map(FlightCard::new).toList();
    }

    public List<FlightCard> getFlightCards() {
        return flightCards;
    }
}
