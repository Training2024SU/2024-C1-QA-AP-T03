package co.com.sofka.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class CommonFunctions {
    protected final WebDriver driver;
    protected final Actions builder;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        this.builder = new Actions(driver);
    }

    protected void typeInto(By locator, String text) {
        driver.findElement(locator).sendKeys(text, Keys.ENTER);
    }

    protected void typeInto(WebElement element, String text) {
        element.sendKeys(text, Keys.ENTER);
    }

    protected void clickSelection(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement element) {
        element.click();
    }

    protected void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void cleanField(WebElement element) {
        element.clear();
    }

    protected void scrollTo(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String getText(Alert alert) {
        return alert.getText();
    }
}
