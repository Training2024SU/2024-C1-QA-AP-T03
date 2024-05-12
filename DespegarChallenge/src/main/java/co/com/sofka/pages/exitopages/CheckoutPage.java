package co.com.sofka.pages.exitopages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//span[text()='Continuar /']")
    private WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='document']")
    private WebElement idField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneField;
    @CacheLookup
    @FindBy(xpath = "//article[@class='exito-checkout-io-0-x-termsContainer false']//input")
    private WebElement termsButton;
    @CacheLookup
    @FindBy(css = "svg.exito-checkout-io-0-x-profileInputSelectContainer .exito-checkout-io-0-x-profileDocumentTypeSelect ")
    private WebElement arrowDown;
    @CacheLookup
    @FindBy(xpath = "//li[text()='Cédula ciudadanía']")
    private WebElement idSelection;
    @CacheLookup
    @FindBy(xpath = "(//article[@class='exito-checkout-io-0-x-privacyPolicyContainer false']//input)[1]")
    private WebElement privacyPolicyButton;
    @CacheLookup
    @FindBy(xpath = "//select[@name='state']")
    private WebElement stateSelection;
    @CacheLookup
    @FindBy(xpath = "//select[@name='city']")
    private WebElement citySelection;
    @CacheLookup
    @FindBy(xpath = "//select[@name='type']")
    private WebElement typeSelection;
    @CacheLookup
    @FindBy(xpath = "//input[@name='mainAddress']")
    private WebElement mainAddress;
    @CacheLookup
    @FindBy(xpath = "//input[@name='firstNumber']")
    private WebElement firstNumberField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='secondNumber']")
    private WebElement secondNumberField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='neighborhood']")
    private WebElement neighborhoodField;
    @CacheLookup
    @FindBy(xpath = "//input[@name='receiverName']")
    private WebElement receiverNameField;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Guardar']")
    private WebElement guardButton;
    @CacheLookup
    @FindBy(xpath = "//button[@class='submit btn btn-success btn-large btn-block'][2]")
    private WebElement submitButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillCheckoutForm(String firstName, String lastName, String id, String phone) {
        waitToBeVisible(firstNameField);
        waitToBeClickable(termsButton);
        click(termsButton);
        waitToBeClickable(privacyPolicyButton);
        click(privacyPolicyButton);


        waitToBeVisible(firstNameField);
        click(firstNameField);
        click(firstNameField);
        clear(firstNameField);
        typeInto(firstNameField, firstName);
        wait(3);

        waitToBeVisible(lastNameField);
        click(lastNameField);
        clear(lastNameField);
        typeInto(lastNameField, lastName);
        wait(3);

        waitToBeVisible(idField);
        wait(3);
        click(idField);
        clear(idField);
        typeInto(idField, id);
        wait(3);

        waitToBeVisible(phoneField);
        wait(3);
        click(phoneField);
        clear(phoneField);
        typeInto(phoneField, phone);

        waitToBeVisible(firstNameField);
        click(firstNameField);
        clear(firstNameField);
        typeInto(firstNameField, firstName);
        wait(3);

        waitToBeVisible(lastNameField);
        click(lastNameField);
        clear(lastNameField);
        typeInto(lastNameField, lastName);
        wait(3);

        waitToBeVisible(idField);
        wait(3);
        click(idField);
        clear(idField);
        typeInto(idField, id);
        wait(3);

        waitToBeVisible(phoneField);
        wait(3);
        click(phoneField);
        clear(phoneField);
        typeInto(phoneField, phone);

        waitToBeClickable(continueButton);
        wait(3);
        clickContinueButton();
    }

    public void fillDeliveryForm(String state, String city, String addresType, String num1, String num2, String num3, String neighborhood, String receiverName) {
        waitToBeVisible(selectState(state));
        select(stateSelection, state);
        select(citySelection, city);
        select(typeSelection, addresType);
        waitToBeClickable(mainAddress);
        click(mainAddress);
        clear(mainAddress);
        typeInto(mainAddress, num1);
        waitToBeClickable(firstNumberField);
        click(firstNumberField);
        clear(firstNumberField);
        typeInto(firstNumberField, num2);
        waitToBeClickable(secondNumberField);
        click(secondNumberField);
        clear(secondNumberField);
        typeInto(secondNumberField, num3);
        waitToBeClickable(neighborhoodField);
        click(neighborhoodField);
        clear(neighborhoodField);
        typeInto(neighborhoodField, neighborhood);
        waitToBeClickable(receiverNameField);
        click(receiverNameField);
        clear(receiverNameField);
        typeInto(receiverNameField, receiverName);

        waitToBeClickable(guardButton);
        click(guardButton);
    }

    public String getText() {
        waitToBeVisible(submitButton);
        return submitButton.getText();
    }

    private void clickContinueButton() {
        waitToBeVisible(continueButton);
        click(continueButton);
    }

    private WebElement selectState(String stateName) {
        String xpath = "//select/option[@value='%s']";
        String xpathFormatted = String.format(xpath, stateName);
        return driver.findElement(By.xpath(xpathFormatted));
    }

    private WebElement selectCity(String cityName) {
        String xpath = "//select/option[@value='%s']";
        String xpathFormatted = String.format(xpath, cityName);
        return driver.findElement(By.xpath(xpathFormatted));
    }
}
