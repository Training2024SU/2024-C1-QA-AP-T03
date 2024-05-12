package co.com.sofka.pages.despegarpages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class HomePage extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//em[text()='Entendí']")
    private WebElement entendiButton;
    @CacheLookup
    @FindBy(xpath = "//em[text()='No quiero beneficios'][2]")
    private WebElement noQuieroBeneficiosButton;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Ingresa desde dónde viajas'])[1]")
    private WebElement originInput;
    @CacheLookup
    @FindBy(xpath = "(//span[@class='item-text'])[1]")
    private WebElement city;
    @CacheLookup
    @FindBy(xpath = "//li[@class='item -active']")
    private WebElement destinationCity;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Ingresa hacia dónde viajas'])[1]")
    private WebElement destinationInput;
    @CacheLookup
    @FindBy(xpath = "//span[text()='Destinos más buscados']")
    private WebElement destinationInputMessage;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Ida'])[1]")
    private WebElement inputIda;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Vuelta'])[1]")
    private WebElement inputVuelta;
    @CacheLookup
    @FindBy(xpath = "//div[@data-month='2024-05']//div[@class='sbox5-monthgrid-datenumber-number'][text()='30']")
    private WebElement flightDate;
    @CacheLookup
    @FindBy(xpath = "(//label[text()='Pasajeros y Clase'])[1]")
    private WebElement pasajerosClaseInput;
    @CacheLookup
    @FindBy(xpath = "(//button[@class='steppers-icon-right stepper__icon'])[1]")
    private WebElement adultsPlusButton;
    @CacheLookup
    @FindBy(xpath = "//em[text()='Buscar']")
    private WebElement buscarButton;
    @CacheLookup
    @FindBy(xpath = "//label[text()='Alojamientos']")
    private WebElement lodgingButton;
    @CacheLookup
    @FindBy(xpath = "//i[@title='Carros']")
    private WebElement carsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchFlight(String origin, String destination, String month, int day, String month2, int day2, int personas) throws InterruptedException {
        isElementDisplayed(originInput);
        click(entendiButton);

        //Select cities
        click(originInput);
        clear(originInput);
        typeInto(originInput, origin);
        waitToBeClickable(city);
        typeEnter(originInput);
        waitToBeClickable(destinationInput);
        click(destinationInput);
        waitToBeVisible(destinationInputMessage);
        clear(destinationInput);
        typeInto(destinationInput, destination);
        waitToBeVisible(destinationCity);
        typeEnter(destinationInput);
        waitToBeClickable(destinationInput);
        typeInto(destinationInput, destination);
        waitToBeClickable(destinationInput);
        typeEnter(destinationInput);

        //Select date
        waitToBeClickable(inputIda);
        click(inputIda);
        waitToBeClickable(setFlightDate(month, day));
        click(setFlightDate(month, day));
        wait(3);
        waitToBeVisible(setFlightDate(month2, day2));
        click(setFlightDate(month2, day2));

        //Select people
        waitToBeClickable(pasajerosClaseInput);
        click(pasajerosClaseInput);
        //Thread.sleep(5000);//delete later
        waitToBeVisible(adultsPlusButton);
        for (int i = 0; i < personas - 1; i++) {
            click(adultsPlusButton);
        }

        try {
            isElementDisplayed(noQuieroBeneficiosButton);
            click(noQuieroBeneficiosButton);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        click(buscarButton);
    }

    public void changeTab() throws InterruptedException {
        Thread.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }
    }

    public void goToLodgingPage() {
        click(lodgingButton);
    }
    public void goToCarsPage(){
        click(carsButton);
    }

    private WebElement setFlightDate(String month, int day) {
        String xpath = "(//div[@data-month='2024-%s']//div[@class='sbox5-monthgrid-datenumber-number'][text()='%s'])[1]";
        String formattedXpath = String.format(xpath, month, day);
        return driver.findElement(By.xpath(formattedXpath));
    }


}
