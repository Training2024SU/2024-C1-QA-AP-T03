package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

abstract public class BasePage {
    protected final WebDriver driver;
    private final JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void scrollTo(By locator) {
        scrollTo(driver.findElement(locator));
    }

    protected void scrollTo(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView()", element);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
