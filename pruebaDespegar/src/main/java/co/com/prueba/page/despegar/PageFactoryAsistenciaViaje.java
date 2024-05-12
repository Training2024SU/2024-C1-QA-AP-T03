package co.com.prueba.page.despegar;

import co.com.prueba.page.functions.FunctionCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static co.com.prueba.util.ConstantesWait.WAIT_TIME;
import static co.com.prueba.util.ExplicitWaitHelper.waitForElementClickable;
import static co.com.prueba.util.ExplicitWaitHelper.waitForElementVisibility;

public class PageFactoryAsistenciaViaje extends FunctionCommons {

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/nav/div[2]/div/div[3]/ul/li[10]/a/div")
    private WebElement BOTON_ASISTENCIA;
    @CacheLookup
    @FindBy(xpath = "//*[@id='searchbox-v2']/div/div/div/div/div/div[3]/div[1]/div/div/div/select")
    private WebElement CAMPO_DESTINO;
    @CacheLookup
    @FindBy(xpath = "//*[@id='searchbox-v2']/div/div/div/div/div/div[3]/div[1]/div/div/div/select/optgroup[1]/option[3]")
    private WebElement CAMPO_DESTINO_ESPECIFICO;
    @CacheLookup
    @FindBy(xpath = "//*[@id='searchbox-v2']/div/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div")
    private WebElement CAMPO_FECHA;
    @CacheLookup
    @FindBy(xpath = "//*[@id='component-modals']/div[1]/div[1]/div/div[1]/div[3]/div[19]/div")
    private WebElement CAMPO_FECHA_DIA;
    @CacheLookup
    @FindBy(css = "input[placeholder='Regreso']")
    private WebElement CAMPO_REGRESO_FECHA;
    @CacheLookup
    @FindBy(xpath = "//*[@id='component-modals']/div[1]/div[1]/div/div[1]/div[3]/div[31]/div")
    private WebElement CAMPO_REGRESO_DIA;
    @CacheLookup
    @FindBy(xpath = "//em[text()='Aplicar'][1]")
    private WebElement BOTON_APLICAR;
    @CacheLookup
    @FindBy(xpath = "//em[text()='Buscar']")
    private WebElement BOTON_BUSCAR;

    @CacheLookup
    @FindBy(xpath = "//em[text()='Comprar']")
    private WebElement OPCION_DE_COMPRA;


    public PageFactoryAsistenciaViaje(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void llenarCampos() {
        //waitForElementVisibility(driver, BOTON_ASISTENCIA, 20);
        waitForElementClickable(driver, BOTON_ASISTENCIA, 5);
        clickSelection(BOTON_ASISTENCIA);
        waitForElementVisibility(driver, CAMPO_DESTINO, WAIT_TIME);
        clickSelection(CAMPO_DESTINO);
        clickSelection(CAMPO_DESTINO_ESPECIFICO);
        clickSelection(CAMPO_FECHA);
        scrollTo(CAMPO_FECHA_DIA);
        waitForElementClickable(driver, CAMPO_FECHA_DIA, 10);
        clickSelection(CAMPO_FECHA_DIA);
        scrollTo(CAMPO_REGRESO_FECHA);
        clickSelection(CAMPO_REGRESO_FECHA);
        clickSelection(CAMPO_REGRESO_DIA);
        scrollTo(CAMPO_REGRESO_FECHA);
        waitForElementClickable(driver, BOTON_APLICAR, 10);
        clickButtonWithoutDropdown(driver, BOTON_APLICAR);
        scrollTo(BOTON_BUSCAR);
        clickSelection(BOTON_BUSCAR);
    }

    public void elegirOpcionCompra() {
        waitForElementVisibility(driver, BOTON_ASISTENCIA, WAIT_TIME);
        waitForElementClickable(driver, BOTON_ASISTENCIA, 10);
        clickSelection(OPCION_DE_COMPRA);
    }
}
