package com.davidbonelo.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightCard extends BaseComponent {
    @FindBy(css = "div[aria-expanded='false'] span[class*='CurrencyAmount'] + span")
    WebElement startingPrice;

    public FlightCard(WebElement root) {
        super(root);
    }

    public String getStartingPrice(){
        return startingPrice.getText();
    }
}
