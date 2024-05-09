package com.davidbonelo.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassCard extends BaseComponent {
    @FindBy(xpath = "./div/div[1]//span/span[last()]")
    private WebElement className;
    @FindBy(css = "span[class*='CurrencyAmount'] + span")
    private WebElement priceSpan;
    @FindBy(css = "button")
    private WebElement selectBtn;

    public ClassCard(WebElement root) {
        super(root);
    }

    public String getName() {
        return className.getText();
    }

    public String getPrice() {
        return priceSpan.getText();
    }

    public void select() {
        selectBtn.click();
        if (getName().equals("Basic")) {
            // reject modal asking to switch class
            By acceptBtnLocator = By.xpath("//span[text()='Aceptar restricciones']/../..");
            clickElement(acceptBtnLocator);
        }
    }
}
