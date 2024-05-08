package co.com.sofka.util.functions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class FunctionsCommon {
    protected final WebDriver driver;



    public FunctionsCommon(WebDriver driver ) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value ){
        driver.findElement(locator).sendKeys(value);
    }

    protected void typeKey(By locator, Keys value ){
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearInput(By locator ){
        driver.findElement(locator).clear();
    }


    protected void clickSelection(By locator ){
        driver.findElement(locator).click();
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected void scrollTo (By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));

    }

    protected void clickAndHold (WebElement origin,WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(origin,target).perform();
    }


    protected void typeInto(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void typeKey(WebElement webElement, Keys value ){
        webElement.sendKeys(value);
    }

    protected void clearInput(WebElement webElement) {
        webElement.clear();
    }

    protected void clickSelection(WebElement webElement) {
        webElement.click();
    }

    protected String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected void scrollTo(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected List<WebElement> findElements(By localtor) {
       return driver.findElements(localtor);
    }

    protected String getAttributeTextElementContent(WebElement element) {
        return element.getAttribute("textContent");
    }

    protected int returnLengthXpath(By locator) {
        return driver.findElements(locator).size();
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
