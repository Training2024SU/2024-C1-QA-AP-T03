package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import garcia.juan.page.util.Meses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static garcia.juan.page.util.Meses.obtenerPorNumero;

public class MainPage extends FunctionsCommon {

    Meses meses;
    protected final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Selectors

    @CacheLookup
    @FindBy(css = "button[data-testid='country-suggestion-reject-change--button']")
    private WebElement COUNTRY_BUTTON;

    @CacheLookup
    @FindBy(css = "button[data-testid='cookies-politics-button--button']")
    private WebElement COOKIES_BUTTON;

    @CacheLookup
    @FindBy(id = "txtInputOrigin_field")
    private WebElement ORIGEN_INPUT;

    @CacheLookup
    @FindBy(id = "lstItem_0")
    private WebElement FIRST_AUTO_ORIGEN;

    @CacheLookup
    @FindBy(id = "txtInputDestination_field")
    private WebElement DESTINO_INPUT;

    @CacheLookup
    @FindBy(id = "btnItemAutoComplete_0")
    private WebElement FIRST_AUTO_DESTINO;

    @CacheLookup
    @FindBy(id = "departureDate")
    private WebElement DEPARTURE_DATE;

    @CacheLookup
    @FindBy(xpath = "//*[@class='DayPickerNavigation_svg__horizontal DayPickerNavigation_svg__horizontal_1']")
    private WebElement MONTH_RIGHT_NAVIGATION;

    @CacheLookup
    @FindBy(id = "btnSearchCTA")
    private WebElement SEARCH_BUTTON;




    private String MES_ANHO= "//div[contains(@class, 'CalendarMonth') and @data-visible='true']/div[@class='CalendarMonth_caption CalendarMonth_caption_1']/strong[text()='%s']";
    private String DAY_PICKER = "//td[contains(@class, 'CalendarDay') and contains(@aria-label, '%s de %s')]";


//    private String mesAnho;
//    @CacheLookup
//    @FindBy(xpath = "//div[contains(@class, 'CalendarMonth_caption')]/strong[text()='"+ mesAnho +"']")
//    private WebElement MES_FECHA


    //Methods
    public void quedarseColombia(){
        try {
            clickSelection(COUNTRY_BUTTON);
        } catch (Exception e){
            System.out.println("Ya esta en col");
        }
    }

    public void acceptCookies (){
        try {
            clickSelection(COOKIES_BUTTON);
        } catch (Exception e){
            System.out.println("No pide cookies");
        }
    }

    public void insertOrigenAndDestino(String origen,String destino) throws InterruptedException {

        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(ORIGEN_INPUT),
                ExpectedConditions.elementToBeClickable(ORIGEN_INPUT)
        ));
        clickSelection(ORIGEN_INPUT);
        typeInto(ORIGEN_INPUT,origen);
        Thread.sleep(500);
        clickSelection(FIRST_AUTO_ORIGEN);
        typeInto(DESTINO_INPUT,destino);
        Thread.sleep(500);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(FIRST_AUTO_DESTINO),
                ExpectedConditions.elementToBeClickable(FIRST_AUTO_DESTINO)
        ));
        clickSelection(FIRST_AUTO_DESTINO);
    }

    public void buscarFecha(String fecha1,String fecha2) throws InterruptedException {
        clickSelection(DEPARTURE_DATE);
        Thread.sleep(500);
        String[] partes1 = fecha1.split("-");
        int anho1 = Integer.parseInt(partes1[0]);
        int mes1 = Integer.parseInt(partes1[1]);
        String dia1 = partes1[2];
        Meses mesD = obtenerPorNumero(mes1);
        buscarMes(mesD.name()+" "+ anho1);
        Thread.sleep(2000);
        pickDay(dia1, mesD.name());
        String[] partes2 = fecha2.split("-");
        int anho2 = Integer.parseInt(partes2[0]);
        int mes2 = Integer.parseInt(partes2[1]);
        int dia2 = Integer.parseInt(partes2[2]);
        Meses mesA = obtenerPorNumero(mes2);
        buscarMes(mesA.name()+" "+ anho2);
        Thread.sleep(2000);
        pickDay(String.valueOf(dia2), mesA.name());

    }

    public void buscarMes(String mesBuscado){
        boolean ciclo = true;
        while (ciclo){
            try {
                WebElement mesElement = driver.findElement(By.xpath(String.format(MES_ANHO,mesBuscado)));
                ciclo=false;
            }catch (Exception e){
                clickSelection(MONTH_RIGHT_NAVIGATION);
                clickSelection(MONTH_RIGHT_NAVIGATION);
            }
        }
    }

    public void pickDay(String dia, String mes){
        clickSelection(By.xpath(String.format(DAY_PICKER,dia,mes)));
    }

    public void realizaBusqueda() {
        clickSelection(SEARCH_BUTTON);
    }
}
