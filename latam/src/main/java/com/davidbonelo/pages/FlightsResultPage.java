package com.davidbonelo.pages;

import com.davidbonelo.pages.components.FlightCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FlightsResultPage extends BasePage {

    private final By flightCardsSelector = By.cssSelector("ol li > div:not" +
            "([data-testid^='banner'])");
    private final By addPassengerBtnLocator = By.id("btnAddPassengerCTA");
    private final By passengersAmountSpanLocator = By.cssSelector("li[data-test='add-passenger" +
            "-body-adult-section'] div div:last-child button + span:not([data-test])");
    private final By plusPassengerBtnLocator = By.id("btnPlusAdults");
    private final By subtractPassengerBtnLocator = By.id("btnSubstractAdults");
    private final By searchBtnLocator = By.xpath("//span[text()='Buscar']");
    @FindBy(xpath = "//span[@class='passenger-text']/..")
    private WebElement passengersBtn;
    private List<FlightCard> flightCards;

    public FlightsResultPage(WebDriver driver) {
        super(driver);
        flightCards = loadFlightCards();
    }

    private List<FlightCard> loadFlightCards() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> cardsElements =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(flightCardsSelector));
        return cardsElements.stream().map(FlightCard::new).toList();
    }

    public List<FlightCard> getFlightCards() {
        return flightCards;
    }

    public String getPassengersAmount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement amount = wait.until(visibilityOfElementLocated(passengersAmountSpanLocator));
        return amount.getText();
    }

    public void setPassengersAmount(int passengerAmount) {
        passengersBtn.click();
        clickElement(addPassengerBtnLocator);
        updatePassengers(passengerAmount);
        clickElement(searchBtnLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.not(visibilityOfElementLocated(plusPassengerBtnLocator)));
        flightCards = loadFlightCards();
    }

    private void updatePassengers(int passengerAmount) {
        int actualAmount = Integer.parseInt(getPassengersAmount());
        while (actualAmount != passengerAmount) {
            actualAmount = Integer.parseInt(getPassengersAmount());
            if (actualAmount < passengerAmount) {
                clickElement(plusPassengerBtnLocator);
            } else if (actualAmount > passengerAmount) {
                clickElement(subtractPassengerBtnLocator);
            } else {
                break;
            }
        }
    }
}
