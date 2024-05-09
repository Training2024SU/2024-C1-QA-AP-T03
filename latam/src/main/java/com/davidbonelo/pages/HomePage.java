package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "header__profile__lnk-sign-in")
    private WebElement signInBtn;
    @FindBy(css = "a[id^='deal-card-']")
    private List<WebElement> destinationsOnOffer;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage navigateToSignInPage() {
        signInBtn.click();
        return new SignInPage(driver);
    }

    public List<String> getDestinationsOnOffer() {
        return destinationsOnOffer.stream().map(this::getDestinationText).toList();
    }

    private String getDestinationText(WebElement destinationCard) {
        return destinationCard.findElement(By.cssSelector("div > div:only-child > span")).getText();
    }

    public FlightsResultPage openDestinationOffer(String destination) {
        for (WebElement destinationCard: destinationsOnOffer){
            if (getDestinationText(destinationCard).equals(destination)){
                destinationCard.click();
                return new FlightsResultPage(driver);
            }
        }
        return null;
    }
}
