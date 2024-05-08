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

public class SelectFlighPage extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public SelectFlighPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(), 'Recomendado')])[1]")
    private WebElement selectFlight;

    @CacheLookup
    @FindBy(id = "bundle-detail-0-flight-select")
    private WebElement selectFLightType;

    @CacheLookup
    @FindBy(id = "button9")
    private WebElement confirmFlight;

    @CacheLookup
    @FindBy(id = "//span[contains(text(), 'Cambiar tu vuelo')]")
    private WebElement changeFlight;


    public void setSelectFlight(){
        wait.until(ExpectedConditions.elementToBeClickable(selectFlight)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectFLightType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmFlight)).click();
    }
}
