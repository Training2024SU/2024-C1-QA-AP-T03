package com.davidbonelo.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightCard extends BaseComponent {
    private final By expandableAreaLocator = By.cssSelector("div[aria-expanded='false']");
    private final By classesLocator = By.cssSelector("ol > li");
    @FindBy(css = "div[aria-expanded='false'] span[class*='CurrencyAmount'] + span")
    WebElement startingPrice;

    public FlightCard(WebElement root) {
        super(root);
    }

    public String getStartingPrice() {
        return startingPrice.getText();
    }

    public void expandDetails() {
        clickElement(expandableAreaLocator);
    }

    public List<ClassCard> getClassesAvailable() {
        List<WebElement> classesCards = root.findElements(classesLocator);
        return classesCards.stream().map(ClassCard::new).toList();
    }
}
