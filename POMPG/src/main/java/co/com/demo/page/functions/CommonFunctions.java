package co.com.demo.page.functions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class CommonFunctions {
    protected final WebDriver driver;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    };

    protected void typeInto(WebElement locator, String value) {
        locator.sendKeys(value);
    };


    protected void clickSelection(By locator){
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement locator) {
        if (locator != null) {
            locator.click();
        } else {
            throw new IllegalArgumentException("Element to click is null");
        }
    }

    protected void scrollTo (By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    };

    protected void scrollTo(WebElement locator) {
        if (locator != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", locator);
        } else {
            throw new IllegalArgumentException("Element to scroll to is null");
        }
    }

    protected void typeKey(WebElement webElement, Keys value ){
        webElement.sendKeys(value);
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement locator){
        return locator.getText();
    }

    protected void clickAndHold (WebElement origin,WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(origin,target).perform();
    }

}
