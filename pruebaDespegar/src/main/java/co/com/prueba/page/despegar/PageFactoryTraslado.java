package co.com.prueba.page.despegar;

import co.com.prueba.page.functions.FunctionCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static co.com.prueba.util.ExplicitWaitHelper.waitForElementClickable;
import static co.com.prueba.util.ExplicitWaitHelper.waitForElementVisibility;

public class PageFactoryTraslado extends FunctionCommons {

    @CacheLookup
    @FindBy(css = "i[product='TRANSFERS']")
    private WebElement PAGINA_TRASLADO;

    @CacheLookup
    @FindBy(css = "input[placeholder='Ingresa un aeropuerto']")
    private WebElement CAMPO_ORIGEN_TRASLADO;
    //*[@id="searchbox-v2"]/div/div/div/div/div/div[3]/div[2]/div[1]/div/div[1]/div/div/input

    @CacheLookup
    @FindBy(xpath = "//em[text()='Buscar']")
    private WebElement BOTON_BUSCAR_TRASLADO;

    @CacheLookup
    @FindBy(css = "span[class='item-text']")
    private WebElement DESTINO_TRASLADO;

    public static String MENSAJE_ERROR = "//span[text()='Ingresa un destino.']";




    public PageFactoryTraslado(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void llenarCampos(){
        clickSelection(PAGINA_TRASLADO);
        waitForElementVisibility(driver, CAMPO_ORIGEN_TRASLADO, 3);
        clickSelection(CAMPO_ORIGEN_TRASLADO);
        CAMPO_ORIGEN_TRASLADO.clear();
        typeInto(CAMPO_ORIGEN_TRASLADO,"Bogo");
        waitForElementClickable(driver, DESTINO_TRASLADO,10);
        clickSelection(DESTINO_TRASLADO);
    }

    public void continuarAccion(){
        clickButtonWithoutDropdown(driver, BOTON_BUSCAR_TRASLADO);
       // clickSelection(BOTON_BUSCAR_TRASLADO);
    }
}
