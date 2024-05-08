package garcia.juan.page.function;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FunctionsCommon {

    protected final WebDriver driver;



    public FunctionsCommon(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator,String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void typeInto(WebElement element,String value){
        element.sendKeys(value);
    }

    protected void typeAutocomplete(By locator,String value){
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(Keys.ENTER);

    }

    protected void clickSelection(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement locator) {
        locator.click();
    }

    protected void clickHolding(By draggable, By droppable) {
        WebElement sourceElement = driver.findElement(draggable);
        WebElement targetElement = driver.findElement(droppable);

        Point targetLocation = targetElement.getLocation();
        int targetX = targetLocation.getX();
        int targetY = targetLocation.getY();

        int xOffset = targetX - sourceElement.getLocation().getX()+10;
        int yOffset = targetY - sourceElement.getLocation().getY()+10;

        new Actions(driver)
                .clickAndHold(sourceElement)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }

//    protected void clickHolding(By locator)
//    {
//        driver.findElement(locator).click();
//        new Actions(driver)
//                .click(driver.findElement(locator))
//                .perform();
//    }

    protected void scrollTo(By locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
        
    }

    protected void scrollTo(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void selectOption(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    protected void selectOption(WebElement locator, String value) {
        WebElement dropdown = locator;
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();

    }
}
