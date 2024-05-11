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

public class ZonaFitSearchProductPage extends FunctionCommons {

    @CacheLookup
    @FindBy(id = "woocommerce-product-search-field-0")
    private WebElement SEARCH_FIELD_PRODUCT;

    @CacheLookup
    @FindBy(xpath = "(//*[@type='submit'])")
    private WebElement SEARCH_BUTTON;

    @CacheLookup
    @FindBy(className = "autocomplete-suggestions")
    private WebElement AUTO_COMPLETE_SUGGESTION;

    @CacheLookup
    @FindBy(xpath = "(//*[@title='Carrito'])[1]")
    private WebElement BUTTON_OPEN_CART_MINI_MENU;

    @CacheLookup
    @FindBy(xpath = "//a[text() ='Ver carrito']")
    private WebElement REDIRECT_CART_BUTTON;



    public ZonaFitSearchProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String Product) {
        SEARCH_FIELD_PRODUCT = driver.findElement(By.id("woocommerce-product-search-field-0"));
        SEARCH_BUTTON = driver.findElement(By.xpath("(//*[@type='submit'])"));
        waitUntilIsClickeable(SEARCH_FIELD_PRODUCT);
        typeInto(SEARCH_FIELD_PRODUCT, Product);

        waitSeconds(1);
        try {
            AUTO_COMPLETE_SUGGESTION = driver.findElement(By.className("autocomplete-suggestions"));
        }catch (Exception e){
            System.out.println("no refresco el elemento");
        }
        waitUntilAppears(AUTO_COMPLETE_SUGGESTION);

        clickSelection(SEARCH_BUTTON);
    }

    public void redirectToCar() {

        clickSelection(BUTTON_OPEN_CART_MINI_MENU);
        try{
            clickSelection(REDIRECT_CART_BUTTON);
        }
        catch (Exception e)
        {
            System.out.println("no se abrio la pestaña de carrito");
        }

    }
}
