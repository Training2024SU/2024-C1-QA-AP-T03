package co.com.sofkau.page.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
public class FunctionCommon {
    protected WebDriver driver;
    private WebElement locator;

    public FunctionCommon(WebDriver driver) {

    }

    public void FunctionsCommon(WebDriver driver){
        this.driver = driver;
        tiempoDeEspera();
    }

    protected void tiempoDeEspera() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    protected void typeInto(WebElement locator, String value) {
        locator.sendKeys(value);
    }
    protected void clickSelection(WebElement element) {
        element.click();
    }
    protected void scrollTo(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
    protected String getText(WebElement element) {
        return element.getText();
    }

}
