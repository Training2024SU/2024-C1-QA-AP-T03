package co.com.sofka.page;

import co.com.sofka.model.FormularioBuscarCommon;
import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class FormularioAlojamientoPage extends FunctionsCommon {

    public FormularioAlojamientoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(15));

    private FormularioBuscarCommon alojamientoForm;


    // localizadores
    @CacheLookup
    @FindBy(xpath = "//div[span[text()='Tramo 1']]//input[contains(@placeholder, 'desde')]")
    private WebElement CAMPO_ORIGEN;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@placeholder, 'alojamiento')]")
    private WebElement CAMPO_DESTINO;

    @CacheLookup
    @FindBy(css = "div#roundTrip button")
    private WebElement RADIO_BUTTON_OP;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class, '-only-start-date-selected')]//a[contains(@class, 'calendar-arrow-right')]")
    private WebElement ARROW_CALENDAR_SELECTED;

    @CacheLookup
    @FindBy(xpath = "(//a[contains(@class, 'calendar-arrow-right')]//*[local-name()='svg'])[1]")
    private WebElement ARROW_RIGHT;

    @CacheLookup
    @FindBy(xpath = "//div[span[text()='Tramo 1']]//input[@placeholder='Ida']")
    private WebElement INPUT_IDA;

    @CacheLookup
    @FindBy(xpath = "//i[@class='suggester-icon-xsm suggester-icon-star']")
    private WebElement SELECT_IMAGE;

    @CacheLookup
    @FindBy(xpath = "(//label[contains(text(),'Pasajeros')]/following-sibling::div[@class='input-container']//input)[1]")
    private WebElement INPUT_PASAJEROS;

    @CacheLookup
    @FindBy(xpath = "(//label[contains(text(),'Pasajeros')]/following-sibling::div[@class='input-container']//input)[1]")
    private WebElement BTN_ADD_PASAJEROS;

    @CacheLookup
    @FindBy(xpath = "//em[text()='Buscar']/ancestor::button")
    private WebElement BTN_BUSCAR;

    private final By SELECT_CIUDAD = By.xpath("(//ul[@class='ac-group-items']//li[1])[1]");

    private final By CLOSE_NOT = By.xpath("//div[contains(@class,'login-incentive--button-close')]");

    private final By ALOJAMIENTO_BUTTON = By.xpath("//i[@title='Alojamientos']");

    public void llenarFormularioBuscarAlojamineto(FormularioBuscarCommon alojamiento){
        this.alojamientoForm = alojamiento;
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        scrollTo(CAMPO_DESTINO);
//        clickSelection(CAMPO_ORIGEN);
//        clearInput(CAMPO_ORIGEN);
//        typeInto(CAMPO_ORIGEN, alojamientoForm.getOrigen());
//        ewait.until(ExpectedConditions.elementToBeClickable(SELECT_CIUDAD));
//        typeKey(CAMPO_ORIGEN, Keys.ENTER);
        ewait.until(ExpectedConditions.elementToBeClickable(CAMPO_DESTINO));
        clickSelection(CAMPO_DESTINO);
        ewait.until(ExpectedConditions.visibilityOf(SELECT_IMAGE));
        clearInput(CAMPO_DESTINO);
        typeInto(CAMPO_DESTINO, alojamientoForm.getDestino());
        ewait.until(ExpectedConditions.elementToBeClickable(SELECT_CIUDAD));
        typeKey(CAMPO_DESTINO, Keys.ENTER);
        llenarDatePicker();

    }

    public void ingresarNumPersonas(){
        clickSelection(INPUT_PASAJEROS);
        ewait.until(ExpectedConditions.elementToBeClickable(BTN_ADD_PASAJEROS));
        for (int i = 0; i < alojamientoForm.getNumPersonas()-1; i++) {
            clickSelection(BTN_ADD_PASAJEROS);
        }
    }

    public void buscarAlojamiento(){
        clickSelection(BTN_BUSCAR);
    }


    public void llenarDatePicker(){
        clickSelection(INPUT_IDA);
        By dayLocatorIda = dayLocator(alojamientoForm.getFechaSalida());
        By dayLocatorRegreso = dayLocator(alojamientoForm.getFechaRegreso());
        for (int i = 0; i < 11; i++) {
            if ((!findElements(dayLocatorIda).isEmpty())) {
                ewait.until(ExpectedConditions.elementToBeClickable(dayLocatorIda));
                clickSelection(dayLocatorIda);
            }
            if((!findElements(dayLocatorRegreso).isEmpty())){
                ewait.until(ExpectedConditions.elementToBeClickable(dayLocatorRegreso));
                clickSelection(dayLocatorRegreso);
                break;
            }

            ewait.until(ExpectedConditions.elementToBeClickable(ARROW_RIGHT));
            clickSelection(ARROW_RIGHT);

        }
    }

    public By dayLocator(Date date){
        // Crear un objeto Calendar y establecer la fecha
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Obtener el número del mes (se indexa desde 0)
        int month = calendar.get(Calendar.MONTH) + 1;
        String monthParse = month < 10 ? "0"+month: month+"";

        //
        int day = calendar.get(Calendar.DAY_OF_MONTH) + 1;

        //

        String locator = "(//div[contains(@data-month,'"+month+"')]//div[contains(text(),'"+day+"')])[1]";

        return By.xpath(locator);

    }

    public void seleccionarAlojamiento(){
        try {
            // Esperar hasta que el elemento esté presente en la página
            ewait.until(ExpectedConditions.elementToBeClickable(CLOSE_NOT));

            clickSelection(CLOSE_NOT);
        } catch (org.openqa.selenium.TimeoutException ignored) {

        }

        clickSelection(ALOJAMIENTO_BUTTON);
    }

}
