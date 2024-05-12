package co.com.sofka.pages.exitopages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//div[@class='exito-checkout-io-0-x-paymentButtonContainer']/button")
    private WebElement payButton;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='correo@email.com']")
    private WebElement email;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Confirmar']")
    private WebElement confirmButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ClickPayButton() {
        waitToBeClickable(payButton);
        click(payButton);
    }

    public void typeEmail(String userEmail) {
        waitToBeVisible(email);
        typeInto(email, userEmail);
        click(confirmButton);
    }
}
