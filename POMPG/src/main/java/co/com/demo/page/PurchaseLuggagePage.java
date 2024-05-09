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

public class PurchaseLuggagePage extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public PurchaseLuggagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "btn-up-segment-MDE-BOG-bag-23-passenger-ADT_1")
    private WebElement selectLuggage;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(), 'Total equipaje')]")
    private WebElement fare;

    @CacheLookup
    @FindBy(id = "BAGS-continue-button")
    private WebElement continueBtn;

    @CacheLookup
    @FindBy(id = "button-cart-confirm")
    private WebElement addContinue;

    @CacheLookup
    @FindBy(id = "BAGS-continue-button")
    private WebElement noluggageButton1;

    @CacheLookup
    @FindBy(id = "PRIORITY_BOARDING-continue-button")
    private WebElement noluggageButton2;

    @CacheLookup
    @FindBy(id = "")
    private WebElement noluggageButton3 ;


    public void addLuggage(){
        wait.until(ExpectedConditions.elementToBeClickable(selectLuggage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(noluggageButton1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(noluggageButton2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addContinue)).click();
    }

    public void continueWithoutLuggage(){
        wait.until(ExpectedConditions.elementToBeClickable(noluggageButton1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(noluggageButton2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addContinue)).click();

    }



}
