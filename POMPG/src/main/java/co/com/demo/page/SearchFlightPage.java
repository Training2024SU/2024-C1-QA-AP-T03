package co.com.demo.page;

import co.com.demo.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SearchFlightPage extends CommonFunctions {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchFlightPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='sc-fhOrUh frWrti']")
    private WebElement bodyPage;

    @CacheLookup
    @FindBy(id = "btnTripTypeCTA")
    private WebElement roundTripOrOneWay;

    @CacheLookup
    @FindBy(id = "btnTripType0")
    private WebElement oneWayTripRadioButton;

    @CacheLookup
    @FindBy(id = "txtInputOrigin_field")
    private WebElement originInput;

    @CacheLookup
    @FindBy(id = "txtInputDestination_field")
    private WebElement destinationInput;

    @CacheLookup
    @FindBy(id = "btnItemAutoComplete_0")
    private WebElement selectOrigin;

    @CacheLookup
    @FindBy(id = "btnItemAutoComplete_0")
    private WebElement selectDestination;

    @CacheLookup
    @FindBy(id = "departureDate")
    private WebElement departureDateInput;

    @CacheLookup
    @FindBy(id = "arrivalDate")
    private WebElement arrivalDateInput;

    @CacheLookup
    @FindBy(xpath = "//td[@aria-label='viernes, 10 de mayo de 2024']")
    private WebElement departureDateSelection;

    @CacheLookup
    @FindBy(xpath = "//td[@aria-label='domingo, 12 de mayo de 2024']")
    private WebElement arrivalDateSelection;


    @CacheLookup
    @FindBy(id = "btnAddPassengerCTA")
    private WebElement selectPassengerOption;

    @CacheLookup
    @FindBy(id = "btnPlusAdults")
    private WebElement IncreasePassengerAmount;

    @CacheLookup
    @FindBy(id = "btnSearchCTA")
    private WebElement searchButton;


    public void selectOneWayTrip() {
        wait.until(ExpectedConditions.elementToBeClickable(roundTripOrOneWay)).click();
        wait.until(ExpectedConditions.elementToBeClickable(oneWayTripRadioButton)).click();
    }

    public void enterOrigin(String origin) {
        wait.until(ExpectedConditions.elementToBeClickable(originInput)).click();
        originInput.sendKeys(origin);
        wait.until(ExpectedConditions.elementToBeClickable(selectOrigin)).click();
    }

    public void enterDestination(String destination) {
        wait.until(ExpectedConditions.elementToBeClickable(destinationInput)).click();
        destinationInput.sendKeys(destination);
        wait.until(ExpectedConditions.elementToBeClickable(selectDestination)).click();
    }

    public void selectDepartureDate() {
        wait.until(ExpectedConditions.elementToBeClickable(departureDateInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(departureDateSelection)).click();
    }

    public void increasePassengers() {
        wait.until(ExpectedConditions.elementToBeClickable(selectPassengerOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(IncreasePassengerAmount)).click();
    }

    public void selectDepartureAndReturnDate() {
        wait.until(ExpectedConditions.elementToBeClickable(departureDateInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(departureDateSelection)).click();
        wait.until(ExpectedConditions.elementToBeClickable(arrivalDateSelection)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(arrivalDateInput)).click();

    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void searchOneFlight(String origin, String destination) {
        selectOneWayTrip();
        enterOrigin(origin);
        enterDestination(destination);
        selectDepartureDate();
        increasePassengers();
        clickSearch();
    }

}
