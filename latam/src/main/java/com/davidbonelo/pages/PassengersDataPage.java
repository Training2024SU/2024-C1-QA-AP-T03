package com.davidbonelo.pages;

import com.davidbonelo.pages.components.PassengerForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class PassengersDataPage extends BasePage {
    @FindBy(css = "div[data-testid^='accordion-passenger-ADT']")
    List<WebElement> passengersAccordions;
    @FindBy(id = "undefined--button-wrapper")
    WebElement continueBtn;

    public PassengersDataPage(WebDriver driver) {
        super(driver);
    }

    public void fillPassengersData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(passengersAccordions));

        // Map to component object giving them it's list index
        List<PassengerForm> passengerForms = IntStream.range(0, passengersAccordions.size())
                .mapToObj(i -> new PassengerForm(passengersAccordions.get(i), i, wait)).toList();

        passengerForms.forEach(PassengerForm::fillData);
    }

    public PaymentPage continueToPayment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        return new PaymentPage(driver);
    }
}
