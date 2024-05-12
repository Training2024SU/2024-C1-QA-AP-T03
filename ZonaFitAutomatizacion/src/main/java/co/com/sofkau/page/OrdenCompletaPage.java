package co.com.sofkau.page;

import co.com.sofkau.page.function.FunctionCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdenCompletaPage extends FunctionCommon {

    //Localizadores
    @CacheLookup
    @FindBy(css = "p.woocommerce-thankyou-order-received")
    private WebElement MENSAJE_DE_EXITO;
    @CacheLookup
    @FindBy(css = "h2.woocommerce-order-details__title")
    private WebElement TITULO_DE_DETALLE_DE_COMPRA;

   //Constructor
    public OrdenCompletaPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String obtenerMensajeDeCompra(){
        waitForElementVisible(MENSAJE_DE_EXITO);

        return MENSAJE_DE_EXITO.getText();
    }

    public boolean esElTituloDeDetalleVisible(){
        waitForElementVisible(TITULO_DE_DETALLE_DE_COMPRA);
        return TITULO_DE_DETALLE_DE_COMPRA.isDisplayed();
    }
}
