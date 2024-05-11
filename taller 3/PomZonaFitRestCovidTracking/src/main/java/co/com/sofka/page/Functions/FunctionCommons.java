package co.com.sofka.page.Functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FunctionCommons {



    protected final WebDriver driver;



    public FunctionCommons(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void typeInto(WebElement locator, String value){
        locator.sendKeys(value);
    }

    protected void clickSelection(By locator){
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement locator){locator.click();}

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement locator){
        return locator.getText();
    }

    protected void presionarEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void limpiarCampo(By locator){driver.findElement(locator).clear();}

    protected void limpiarCampo(WebElement locator){locator.clear();}

    protected void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(locator));
    }

    protected void scrollTo(WebElement locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();"
                ,locator);
    }

    public void waitSeconds(int seconds) {
        //NO FUNCIONA CON MODULOS WEBS CON ALERTAS
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        try{
            wait.until(ExpectedConditions.alertIsPresent());
        }catch (Exception e){
        }
    }
    public void waitUntilAppears(WebElement webElement){
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void waitUntilIsClickeable(WebElement webElement){
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(8))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
