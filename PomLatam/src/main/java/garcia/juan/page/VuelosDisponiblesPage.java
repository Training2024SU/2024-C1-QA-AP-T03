package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VuelosDisponiblesPage extends FunctionsCommon {

    public VuelosDisponiblesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Selectors

    @CacheLookup
    @FindBy(xpath = "//div[@id='WrapperCardFlight0']//div[@class='cardFlightstyle__FlightSummaryTagWrapper-sc__sc-1fa5kbc-11 fbBWZI']")
    private WebElement VUELO_RECOMENDADO;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class, 'cardWidgetFlightstyle__ContentContainer-sc__sc-913suc-1')]")
    private WebElement VUELO_SELECCIONADO;
    @CacheLookup
    @FindBy(xpath = "//div[@id='WrapperCardFlight1']//div[@class='cardFlightstyle__FlightSummaryTagWrapper-sc__sc-1fa5kbc-11 fbBWZI']")
    private WebElement VUELO_RECOMENDADO2;
    @CacheLookup
    @FindBy(xpath = "//li[@id='WrapperBundleCardbundle-detail-00']//button[@data-testid='bundle-detail-0-flight-select']")
    private WebElement BOTON_ELEGIR;
    @CacheLookup
    @FindBy(xpath = "//li[@id='WrapperBundleCardbundle-detail-01']//button[@data-testid='bundle-detail-0-flight-select']")
    private WebElement BOTON_ELEGIR2;
    @CacheLookup
    @FindBy(id = "button9")
    private WebElement BOTON_ASIENTOS;
    @CacheLookup
    @FindBy(id = "btn-next-flight")
    private WebElement BOTON_CONTINUAR_ASIENTOS1;
    @CacheLookup
    @FindBy(id = "btn-confirm-and-continue")
    private WebElement BOTON_CONTINUAR_ASIENTOS;

    public void clickVueloRecomendado() throws InterruptedException {
        esperarClickable(VUELO_RECOMENDADO);
        scrollTo(VUELO_RECOMENDADO);
        clickSelection(VUELO_RECOMENDADO);

        esperarClickable(BOTON_ELEGIR);
        scrollTo(BOTON_ELEGIR);
        clickSelection(BOTON_ELEGIR);
        esperarVisible(VUELO_SELECCIONADO);
    }
    public void clickVueloRecomendado2() throws InterruptedException {
        esperarClickable(VUELO_RECOMENDADO2);
        scrollTo(VUELO_RECOMENDADO2);
        clickSelection(VUELO_RECOMENDADO2);

        esperarClickable(BOTON_ELEGIR2);
        scrollTo(BOTON_ELEGIR2);
        clickSelection(BOTON_ELEGIR2);
    }

    public void irAAsientos(){
        esperarClickable(BOTON_ASIENTOS);
        scrollTo(BOTON_ASIENTOS);
        clickSelection(BOTON_ASIENTOS);
    }

    public void pasarAlsiguienteAsientos(){
        esperarClickable(BOTON_CONTINUAR_ASIENTOS1);
        scrollTo(BOTON_CONTINUAR_ASIENTOS1);
        clickSelection(BOTON_CONTINUAR_ASIENTOS1);
    }

    public void ignorarAsientos(){
        esperarClickable(BOTON_CONTINUAR_ASIENTOS);
        scrollTo(BOTON_CONTINUAR_ASIENTOS);
        clickSelection(BOTON_CONTINUAR_ASIENTOS);
    }


}
