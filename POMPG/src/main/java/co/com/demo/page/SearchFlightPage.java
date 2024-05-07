package co.com.demo.page;

import co.com.demo.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class SearchFlightPage extends CommonFunctions {

    private WebDriver driver;

    @CacheLookup
    @FindBy(xpath = "//div[@class='sc-fhOrUh frWrti']")
    private WebElement bodyPage;

    // One way or round trip selection
    @CacheLookup
    @FindBy(id = "btnTripTypeCTA")
    private WebElement roundTripOrOneWay;

    // One way selection
    @CacheLookup
    @FindBy(id = "btnTripType0")
    private WebElement oneWayTripRadioButton;

    @CacheLookup
    @FindBy(id = "btnAddPassengerCTA")
    private WebElement selectPassengerOption;

    @CacheLookup
    @FindBy(css = "span[data-test='adult_added_a11y']")
    private WebElement selectPassengerAmount;

    @CacheLookup
    @FindBy(id = "btnItemAutoComplete_0")
    private WebElement selectOrigin;

    @CacheLookup
    @FindBy(id = "btnItemAutoComplete_0")
    private WebElement selectDestination;

    @CacheLookup
    @FindBy(id = "txtInputOrigin_field")
    private WebElement originInput;

    @CacheLookup
    @FindBy(id = "txtInputDestination_field")
    private WebElement destinationInput;

    @CacheLookup
    @FindBy(id = "departureDate")
    private WebElement departureDateInput;

    @CacheLookup
    @FindBy(id = "btnSearchCTA")
    private WebElement searchButton;

    public SearchFlightPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectOneWayTrip() {
        clickSelection(roundTripOrOneWay);
        clickSelection(oneWayTripRadioButton);
    }

    public void enterOrigin(String origin) {
        clickSelection(originInput);
        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(originInput));
        typeInto(originInput,origin);
        clickSelection(selectOrigin);
    }

    public void enterDestination(String destination) {
        clickSelection(destinationInput);
        typeInto(destinationInput, destination);
        clickSelection(selectDestination);
    }

    public void increasePassengers(){
        clickSelection(selectPassengerOption);
        clickSelection(bodyPage);
        //clickSelection(selectPassengerAmount);
    }

    public void selectDepartureDate(String date) {
        String formattedDate = date.format(String.valueOf(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        typeInto(departureDateInput, formattedDate);
    }

    public void clickSearch() {
        clickSelection(searchButton);
    }

    public void searchOneFlight (){
        selectOneWayTrip();
        enterOrigin("medellin");
        enterDestination("bogota");
        clickSearch();

    }

}
