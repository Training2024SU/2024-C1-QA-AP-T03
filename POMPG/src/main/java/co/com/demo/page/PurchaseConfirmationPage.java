package co.com.demo.page;

import co.com.demo.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchaseConfirmationPage extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public PurchaseConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(@class, 'expanded-title') and contains(text(), 'Detalle de viaje')]")
    private WebElement flightDetails;

    @CacheLookup
    @FindBy(xpath = "//span[text()='FULL']")
    private WebElement newTicker;

    @FindBy(xpath = "//span[contains(text(), 'Equipaje') and contains(text(), 'Total: 0 Peso colombiano')]")
    private WebElement luggageTotal;

    @FindBy(xpath = "//span[contains(text(), 'Asientos') and contains(text(), 'Total: 0 Peso colombiano')]")
    private WebElement seatsTotal;


    public String getSeatsTotalText() {
        return luggageTotal.getText();
    }

    public String getLuggageTotalText() {
        return luggageTotal.getText();
    }

    public String getNewTickerText() {
        return newTicker.getText();
    }

    public String getFlightDetailsMessage(){
        return getText(flightDetails);
    }

}

