package co.com.sofkau.page;

import co.com.sofkau.page.function.FunctionCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCompletaPage extends FunctionCommon {
    public OrderCompletaPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p.woocommerce-thankyou-order-received")
    private WebElement MENSAJE_DE_EXITO;

    @FindBy(css = "h2.woocommerce-order-details__title")
    private WebElement TITULO_DE_DETALLE_DE_COMPRA;

    public void 
}
