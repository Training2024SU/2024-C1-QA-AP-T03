package co.com.sofka.pages.functions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    protected final WebDriver driver;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(WebElement locator, String value) {
        locator.sendKeys(value);
    }

    protected void click(WebElement locator) {
        locator.click();
    }

    protected String getText(WebElement locator) {
        return locator.getText();
    }

    protected void scrollTo(WebElement locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", locator);
    }
    protected  void typeIntoAndEnter(WebElement locator, String text){
        locator.sendKeys(text, Keys.TAB);
    }
    protected void typeEnter(WebElement locator) {
        locator.sendKeys(Keys.ENTER);
    }

    protected void typeTab(WebElement locator) {
        locator.sendKeys(Keys.TAB);
    }
    protected void typeIntoAndDown(WebElement locator, String text){
        locator.sendKeys(text, Keys.ARROW_DOWN, Keys.ENTER);
    }
    protected void typeDownAndEnter(WebElement locator){
        locator.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }
    protected void waitToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void waitToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    protected void wait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    protected void clear(WebElement locator) {
        locator.clear();
    }
}
