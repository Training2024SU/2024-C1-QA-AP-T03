package co.com.sofkau.page.function;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class FunctionCommon {
    protected static WebDriver driver;
    private WebElement locator;

    public FunctionCommon(WebDriver driver) {
        this.driver = driver;
        tiempoDeEspera();
    }

    protected void tiempoDeEspera() {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    protected void typeInto(WebElement locator, String value) {
        locator.sendKeys(value);
    }

    protected void typeEntryKey(WebElement locator){
        locator.sendKeys(Keys.ENTER);
    }

    protected static void clickSelection(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void scrollTo(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void waitForGeneralPageLoad(){
        WebElement cargandoPagina = driver.findElement(By.xpath("//div[@class='page-loader-logo']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(cargandoPagina));
    }

    protected void waitForElementInvisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
