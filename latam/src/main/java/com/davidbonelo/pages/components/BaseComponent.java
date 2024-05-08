package com.davidbonelo.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent {
    @FindBy(xpath = ".")
    protected final WebElement root;

    public BaseComponent(WebElement root) {
        this.root = root;
        PageFactory.initElements(root, this);
    }

    protected void clickElement(By locator) {
        clickElement(root.findElement(locator));
    }

    protected void clickElement(WebElement element) {
        element.click();
    }
}
