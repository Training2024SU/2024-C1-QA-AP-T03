package com.davidbonelo.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent {
    private final WebElement root;

    public BaseComponent(WebElement root) {
        this.root = root;
        PageFactory.initElements(root, this);
    }
}
