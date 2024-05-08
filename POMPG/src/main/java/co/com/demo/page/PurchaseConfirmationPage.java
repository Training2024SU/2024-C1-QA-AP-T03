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
    @FindBy(xpath = "")
    private WebElement purchaseDetails;

    @CacheLookup
    @FindBy(id = "")
    private WebElement addCrediCard;

    @CacheLookup
    @FindBy(id = "")
    private WebElement InputCreditCard;

    @CacheLookup
    @FindBy(id = "")
    private WebElement fullName;

    @CacheLookup
    @FindBy(id = "")
    private WebElement expirationDate;

    @CacheLookup
    @FindBy(id = "")
    private WebElement emailReceipt;

    @CacheLookup
    @FindBy(id = "")
    private WebElement acceptTermsAndConditions;

    @CacheLookup
    @FindBy(id = "")
    private WebElement paymentButton;

}

