package com.davidbonelo.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassCard extends BaseComponent {
    @FindBy(css = "span[class*='CurrencyAmount'] + span")
    private WebElement priceSpan;

    public ClassCard(WebElement root) {
        super(root);
    }

    public String getPrice() {
        return priceSpan.getText();
    }
}
