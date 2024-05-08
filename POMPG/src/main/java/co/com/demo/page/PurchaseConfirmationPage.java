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
    @FindBy(xpath = "//span[contains(text(), 'Revisa el detalle de tu compra')]")
    private WebElement reviewPurchaseDetailSpan;

    @FindBy(xpath = "//label[@data-testid='new-credit-card-payment-method-radio-accordion-item--radio__label']")
    private WebElement addCreditCard;

    @FindBy(xpath = "//span[contains(text(), 'Número de tarjeta')]")
    private WebElement InputCreditCard;

    @CacheLookup
    @FindBy(id = "//span[contains(text(), 'Nombre y apellido')]")
    private WebElement fullName;

    @CacheLookup
    @FindBy(id = "//span[contains(text(), 'Expiración')]")
    private WebElement expirationDate;

    @FindBy(xpath = "//span[contains(text(), 'Email')]")
    private WebElement emailReceipt;

    @FindBy(css = "span[data-testid='checkbox-id--checkbox-styled']")
    private WebElement acceptTermsAndConditions;

    @CacheLookup
    @FindBy(id = "paymentCTA")
    private WebElement paymentButton;

}

