package co.com.sofka.page;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

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
        element.sendKeys(text);
    }

    protected void waitToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
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
