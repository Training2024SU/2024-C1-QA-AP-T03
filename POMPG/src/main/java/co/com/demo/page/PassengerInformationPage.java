package co.com.demo.page;

import co.com.demo.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PassengerInformationPage extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public PassengerInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//label[@for='passengerDetails-firstName-ADT_1' and contains(text(), 'Nombre')]")
    private WebElement firstNameLabel;

    @CacheLookup
    @FindBy(xpath = "//label[@for='passengerDetails-lastName-ADT_1' and contains(text(), 'Apellido')]")
    private WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@aria-label='Ingresa la fecha de nacimiento de pasajero.']")
    private WebElement dateOfBirth;

    @CacheLookup
    @FindBy(id = "")
    private WebElement gender;

    @CacheLookup
    @FindBy(id = "")
    private WebElement country;

    @CacheLookup
    @FindBy(xpath = "//input[@aria-label='ingresa el número de documento de pasajero.']")
    private WebElement documentNumber;

    @CacheLookup
    @FindBy(id = "//input[@aria-label='Ingresa el email de pasajero.']")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "//input[@aria-label='ingresa el número de teléfono de pasajero.']")
    private WebElement phoneNumber;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@aria-label, 'Guardar los datos')]")
    private WebElement saveDataButton;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='Continuar al paso de pago.']")
    private WebElement continueToPaymentButton;
}
