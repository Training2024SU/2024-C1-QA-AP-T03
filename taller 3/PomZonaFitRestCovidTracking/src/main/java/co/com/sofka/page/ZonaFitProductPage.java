package co.com.sofka.page;

import co.com.sofka.page.Functions.FunctionCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZonaFitProductPage extends FunctionCommons {

    @CacheLookup
    @FindBy(id = "menu-item-198594")
    private WebElement BOTON_REDIRECT_PRODUCTS;

    @CacheLookup
    @FindBy(xpath = "//*[text() = 'Añadir al carrito']")
    private WebElement ADD_TO_CAR_BUTTON;

    @CacheLookup
    @FindBy(id = "cart-popup")
    private WebElement MINI_CAR_POPUP;

    @CacheLookup
    @FindBy(className = "mfp-close")
    private WebElement CLOSE_MINI_CAR_POPUP_BUTTON;

    private final By FLAVOR_OPTIONS = By.xpath("//*[@class='variations']//*[@class='ux-swatches ux-swatches-attribute-ux_label ux-swatches--large ux-swatches--rounded']");



    public ZonaFitProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void redirectToProducts(){
        BOTON_REDIRECT_PRODUCTS = driver.findElement(By.id("menu-item-198594"));
        clickSelection(BOTON_REDIRECT_PRODUCTS);
    }


    public void SelectFlavoAddToCar(){

        try{
            selectFlavor();
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            System.out.println("Flavor option unable to be find");
        }
        addProductToCar();
        waitSeconds(2);
    }


    public void selectFlavor(){
        try {
            Random random = new Random();
            List<WebElement> allOptions = driver.findElements(FLAVOR_OPTIONS);
            waitSeconds(2);
            List<WebElement> enabledOptions = new ArrayList<>();
            for (WebElement option : allOptions) {
                if (!option.getAttribute("class").contains("disabled")) {
                    enabledOptions.add(option);
                }
            }
            int randomIndex = random.nextInt(enabledOptions.size());
            clickSelection(enabledOptions.get(randomIndex));
        }catch (Exception e){
            System.out.println("no se consiguieron opciones de sabor");
        }
    }

    public void addProductToCar(){
        ADD_TO_CAR_BUTTON = driver.findElement(By.xpath("//*[text() = 'Añadir al carrito']"));
        clickSelection(ADD_TO_CAR_BUTTON);
    }



    public void closeCarPopUp(){
        try {
            MINI_CAR_POPUP = driver.findElement(By.id("cart-popup"));
            CLOSE_MINI_CAR_POPUP_BUTTON = driver.findElement(By.className("mfp-close"));
            Wait<WebDriver> wait =
                    new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(5))
                            .pollingEvery(Duration.ofMillis(300))
                            .ignoring(ElementNotInteractableException.class);

            wait.until(ExpectedConditions.visibilityOf(MINI_CAR_POPUP));

            clickSelection(CLOSE_MINI_CAR_POPUP_BUTTON);
        }catch (Exception e){
            System.out.println("no popup menu");
        }
    }

}
