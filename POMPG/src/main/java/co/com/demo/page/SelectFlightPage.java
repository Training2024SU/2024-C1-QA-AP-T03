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

public class SelectFlightPage extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public SelectFlightPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='WrapperCardFlight2']/div")
    @CacheLookup
    private WebElement selectFlight;

    @FindBy(xpath = "//*[@id='WrapperCardFlight2']/div")
    @CacheLookup
    private WebElement selectNewFlight;

    @CacheLookup
    @FindBy(id = "bundle-detail-1-flight-select")
    private WebElement selectFLightType;

    @CacheLookup
    @FindBy(id = "bundle-detail-2-flight-select")
    private WebElement selectNewFLightType;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(), 'Cambiar tu vuelo')]")
    private WebElement changeFlight;

    @CacheLookup
    @FindBy(id = "button9")
    private WebElement redirectSeatsSelection;


    public void selectFlight(){
        wait.until(ExpectedConditions.elementToBeClickable(selectFlight)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectFLightType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(redirectSeatsSelection)).click();
    }

    public void selectNewFlight(){
        wait.until(ExpectedConditions.elementToBeClickable(selectFlight)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectFLightType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(changeFlight)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectNewFlight)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectNewFLightType)).click();

    }
}
