package co.com.prueba.page.functions;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;
import java.util.Random;

public class FunctionCommons {

    protected final WebDriver driver;

    public FunctionCommons(WebDriver driver) {
        this.driver = driver;
    }

    protected  void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected  void typeInto(WebElement locator, String value){
        locator.sendKeys(value);
    }

    protected void clickSelection(By locator){
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement locator){
        locator.click();
    }

    protected void clickSelection(WebElement locator, String value){
        locator.click();
        locator.sendKeys(value);
    }

    protected void hacerClic(WebDriver driver, By locator, String s) {
        WebElement elemento = driver.findElement(locator);
        elemento.click();
    }
    protected  String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void scrollTo(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void selectOption(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    protected void selectOption(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    protected int anioAleatorio(){
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(2025 - 1930 + 1) + 1930;
        return numeroAleatorio;
    }

    protected int mesAleatorio(){
        Random rand = new Random();
        int mesAleatorio = rand.nextInt(12) + 1;
        int mesAleatorioFormateado = Integer.parseInt(String.format("%02d", mesAleatorio));
        return mesAleatorioFormateado;
    }

    protected int diaAleatorio(){
        Random random = new Random();
        int diaAleatorio = random.nextInt(19) + 10;
        //String diaFormateado = String.format("%02d", diaAleatorio);
        return (diaAleatorio);
    }
    public static String nameAlert(){
        Faker faker = new Faker(new Locale("es"));
        String nombre = faker.name().firstName();
        return nombre;
    }

    protected String generarDireccion(){
        Faker faker = new Faker(new Locale("es"));
        String nombreCalle = faker.address().streetName();
        String numeroCalle = faker.address().buildingNumber();
        String ciudad = faker.address().city();
        String direccion = nombreCalle + " " + numeroCalle + ", " + ciudad;
        return direccion;
    }

    protected void switchToIframe(WebDriver driver, WebElement iframeElement) {
        driver.switchTo().frame(iframeElement);
    }

    public static void clickButtonWithoutDropdown(WebDriver driver, WebElement button) {
        try {
            // Intenta hacer clic directamente en el botón utilizando JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        } catch (WebDriverException e) {
            // Si no se pudo hacer clic directamente, intenta usar Actions para forzar el clic
            Actions actions = new Actions(driver);
            actions.moveToElement(button).click().perform();
        }
    }
}
