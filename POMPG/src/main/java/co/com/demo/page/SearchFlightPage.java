package co.com.demo.page;

import co.com.demo.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.format.DateTimeFormatter;

public class SearchFlightPage extends CommonFunctions {

    private WebDriver driver;

    @FindBy(id = "btnTripTypeCTA")
    private WebElement oneWayRoundtrip;

    @FindBy(id = "btnTripType0")
    private WebElement oneWayTripRadioButton;

    @FindBy(id = "txtInputOrigin_field")
    private WebElement originInput;

    @FindBy(id = "txtInputDestination_field")
    private WebElement destinationInput;

    @FindBy(id = "departureDate")
    private WebElement departureDateInput;

    @FindBy(id = "btnSearchCTA")
    private WebElement searchButton;

    public SearchFlightPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectRoundTrip() {
        clickSelection(oneWayTripRadioButton);
    }

    public void selectRoundOneWay() {
        clickSelection(oneWayRoundtrip);
    }

    public void enterOrigin(String origin) {
        typeInto(originInput, origin);
    }

    public void enterDestination(String destination) {
        typeInto(destinationInput, destination);
    }

    public void selectDepartureDate(String date) {
        String formattedDate = date.format(String.valueOf(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        typeInto(departureDateInput, formattedDate);
    }

    public void clickSearch() {
        clickSelection(searchButton);
    }

    // Additional methods can be added here as needed

    public void searchOneFlight (){
        selectRoundOneWay();
        enterOrigin("MDE");
        enterDestination("BOG");
        selectDepartureDate("05/20/2024");
        clickSearch();

    }

}
