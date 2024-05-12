package co.com.sofka.page.function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FunctionsCommon {
    protected final WebDriver driver;

    public FunctionsCommon(WebDriver driver) {
        this.driver = driver;
    }

    protected void ingresarTexto(By locator, String texto) {
        driver.findElement(locator).sendKeys(texto);
    }

    protected void ingresarTexto(WebElement locator, String texto) {
        locator.sendKeys(texto);
    }

    protected void clickSelection(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement locator) {
        locator.click();
    }

    public void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void scrollTo(WebElement locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", locator);
    }

    protected String obtenerTexto(By locator) {
        return driver.findElement(locator).getText();
    }

    protected String obtenerTexto(WebElement locator) {
        return locator.getText();
    }

    protected void mantenerMover(By locatorIni, By locatorFin) {
        WebElement draggable = driver.findElement(locatorIni);
        WebElement droppable = driver.findElement(locatorFin);
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
    }

    protected void esperarElementoVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void esperarElementoInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void esperarCarguePagina() {
        WebElement cargaDePagina = driver.findElement(By.xpath("//div[@class='page-loader-logo']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(cargaDePagina));
    }

}
