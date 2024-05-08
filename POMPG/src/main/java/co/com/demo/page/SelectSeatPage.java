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

public class SelectSeatPage  extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public SelectSeatPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(css = "button[data-testid='button-seat-3E']")
    private WebElement selectSeat;

    @CacheLookup
    @FindBy(css = "button[data-testid='button-seat-4E']")
    private WebElement selecAnothertSeat;


    @CacheLookup
    @FindBy(id = "btn-confirm-and-continue")
    private WebElement confirmSeats;

    @CacheLookup
    @FindBy(id = "")
    private WebElement addContinue;


    @CacheLookup
    @FindBy(id = "btn-confirm-and-continue")
    private WebElement continueWithoutSeats;

    @CacheLookup
    @FindBy(css = "button[data-testid='buttonChooseLater--button']")
    private WebElement chooseLaterSeats;


    public void selectSeats(){
        wait.until(ExpectedConditions.elementToBeClickable(selectSeat)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selecAnothertSeat)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmSeats)).click();
    }


    public void continueWithoutSeats(){
        wait.until(ExpectedConditions.elementToBeClickable(continueWithoutSeats)).click();
        wait.until(ExpectedConditions.elementToBeClickable(chooseLaterSeats)).click();

    }

}

