package co.com.sofka.page;

import co.com.sofka.page.Functions.FunctionCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZonaFitMainPage extends FunctionCommons {

    @CacheLookup
    @FindBy(id = "menu-item-198594")
    private WebElement BOTON_REDIRECT_PRODUCTS;

    public ZonaFitMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void redirectToProducts(){
        clickSelection(BOTON_REDIRECT_PRODUCTS);
    }
}
