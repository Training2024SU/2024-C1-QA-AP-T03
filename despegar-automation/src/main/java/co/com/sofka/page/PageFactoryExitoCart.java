package co.com.sofka.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageFactoryExitoCart extends CommonFunctions{
    @CacheLookup
    @FindBy(css = "input[name='email']")
    WebElement CART_EMAIL_INPUT;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement CONFIRM_EMAIL_BTN;

    @CacheLookup
    @FindBy(xpath = "//div[@class='exito-checkout-io-0-x-paymentButtonContentText']")
    WebElement CONFIRM_ITEMS_BTN;


    // Scroll to pivot
    @CacheLookup
    @FindBy(xpath = "//p[@class='exito-checkout-io-0-x-headerText']")
    WebElement UP_TEXT;

    @CacheLookup
    @FindBy(xpath = "//span[@class='exito-checkout-io-0-x-footerBarSpan']")
    WebElement DOWN_TEXT;

    private final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public PageFactoryExitoCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void confirmItems() {
        try {
            waitToBeVisible(CONFIRM_ITEMS_BTN);
            waitToBeClickable(CONFIRM_ITEMS_BTN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scrollTo(CONFIRM_ITEMS_BTN);
        customWait();
        clickSelection(CONFIRM_ITEMS_BTN);
    }

    public void submitEmail(String email) {
        try {
            waitToBeClickable(CART_EMAIL_INPUT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cleanField(CART_EMAIL_INPUT);
        typeInto(CART_EMAIL_INPUT, email);
        clickSelection(CONFIRM_EMAIL_BTN);
    }
    private synchronized void customWait() {
        try {
            wait(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
