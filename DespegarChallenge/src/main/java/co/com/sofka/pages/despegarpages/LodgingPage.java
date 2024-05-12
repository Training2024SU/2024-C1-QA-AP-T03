package co.com.sofka.pages.despegarpages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LodgingPage extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Ingresa una ciudad, alojamiento o punto de interés']")
    private WebElement destinationInput;
    @CacheLookup
    @FindBy(xpath = "//li[@class='item -active']")
    private WebElement destinationCity;
    @CacheLookup
    @FindBy(xpath = "//label[text()='Fechas']")
    private WebElement dateInput;

    public LodgingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchLodging(String destination) throws InterruptedException {
        isElementDisplayed(destinationInput);
        click(destinationInput);
        clear(destinationInput);
        typeInto(destinationInput, destination);
        waitToBeClickable(destinationCity);
        typeEnter(destinationInput);

        click(dateInput);
    }
}
