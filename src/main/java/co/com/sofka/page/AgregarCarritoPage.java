package co.com.sofka.page;

import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AgregarCarritoPage extends FunctionsCommon {

    private String correo;

    public AgregarCarritoPage(WebDriver driver, String correo) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.correo = correo;
    }

    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // localizadores
    @CacheLookup
    @FindBy(xpath = "(//div[@class='categorie-buble_fs-categorie-buble__qvarR'])[4]")
    private WebElement CATEGORIA_PROM;

    @CacheLookup
    @FindBy(xpath = "(//button[@class='DefaultStyle_default__jW12W '])[1]")
    private WebElement AGREGAR_CARRITO;

    @CacheLookup
    @FindBy(xpath = "(//article[@data-testid='store-product-card'])[1]")
    private WebElement ARTICLE_PRODUCT;

    @CacheLookup
    @FindBy(xpath = "//h2[@data-testid='total-product-count']")
    private WebElement LABEL_TOTAL;

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(),'Compra')]")
    private WebElement LABEL_CATEGORIA;

    @CacheLookup
    @FindBy(css="button[data-testid='cart-toggle']")
    private WebElement CAR_BUTTON;

    @CacheLookup
    @FindBy(css="svg.exito-checkout-io-0-x-iconAddActive")
    private WebElement BUTTON_ADD_PRODUCT;

    @CacheLookup
    @FindBy(css="div.exito-checkout-io-0-x-paymentButtonContentText")
    private WebElement BUTTON_IR_PAGAR;

    @CacheLookup
    @FindBy(className="exito-checkout-io-0-x-preLoginActiveButton")
    private WebElement BUTTON_CONFIRMAR;

    @CacheLookup
    @FindBy(xpath="//input[@placeholder='correo@email.com']")
    private WebElement INPUT_CORREO;


    // métodos
    public void elegirProducto(){
        scrollTo(LABEL_CATEGORIA);
        ewait.until(ExpectedConditions.elementToBeClickable(CATEGORIA_PROM));
        clickSelection(CATEGORIA_PROM);
        scrollTo(LABEL_TOTAL);
        ewait.until(ExpectedConditions.elementToBeClickable(AGREGAR_CARRITO));
        clickSelection(AGREGAR_CARRITO);
        clickSelection(CAR_BUTTON);
    }


    public void elegirCantidadProductos(){
        for (int i = 0; i < 4-1; i++) {
            ewait.until(ExpectedConditions.elementToBeClickable(BUTTON_ADD_PRODUCT));
            clickSelection(BUTTON_ADD_PRODUCT);
        }
        clickSelection(BUTTON_IR_PAGAR);
        ewait.until(ExpectedConditions.elementToBeClickable(INPUT_CORREO));
        typeInto(INPUT_CORREO,correo);
        clickSelection(BUTTON_CONFIRMAR);
    }
}
