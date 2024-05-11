package co.com.sofka.page;

import co.com.sofka.model.PurchaseWithoutLogFormModel;
import co.com.sofka.page.Functions.FunctionCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ZonaFitCheckOut extends FunctionCommons {

    @CacheLookup
    @FindBy(id = "billing_myfield12")
    private WebElement ID_FIELD;

    @CacheLookup
    @FindBy(id = "billing_email")
    private WebElement EMAIL_FIELD;

    @CacheLookup
    @FindBy(id = "billing_first_name")
    private WebElement FIRST_NAME_FIELD;

    @CacheLookup
    @FindBy(id = "billing_last_name")
    private WebElement LAST_NAME_FIELD;

    @CacheLookup
    @FindBy(id = "billing_state_field")
    private WebElement STATE_FIELD;

    @CacheLookup
    @FindBy(xpath = "//select[@name='billing_state']")
    private WebElement STATE_FIELD_ANSWER;

    @CacheLookup
    @FindBy(id = "billing_city_field")
    private WebElement CITY_FIELD;

    @CacheLookup
    @FindBy(xpath = "//select[@id='billing_city']")
    private WebElement CITY_FIELD_ANSWER;

    @CacheLookup
    @FindBy(id = "billing_address_1")
    private WebElement ADDRESS_ONE_FIELD;

    @CacheLookup
    @FindBy(id = "billing_address_2")
    private WebElement ADDRESS_TWO_FIELD;

    @CacheLookup
    @FindBy(id = "billing_phone")
    private WebElement PHONE_NUMBER_FIELD;

    @CacheLookup
    @FindBy(id = "payment_method_bank_transfer_1")
    private WebElement BALOTO_PAYMENT_METHOD_BUTTON;

    @CacheLookup
    @FindBy(id = "place_order")
    private WebElement PLACE_ORDER_BUTTON;

    @CacheLookup
    @FindBy(id = "terms")
    private WebElement TERMS_ACCEPT;







    public ZonaFitCheckOut(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillForm(PurchaseWithoutLogFormModel purchaseWithoutLogFormModel){


        waitSeconds(2);

        typeInto(ID_FIELD, purchaseWithoutLogFormModel.getIdNumber());
        typeInto(EMAIL_FIELD,purchaseWithoutLogFormModel.getEmail());
        typeInto(FIRST_NAME_FIELD,purchaseWithoutLogFormModel.getName());
        typeInto(LAST_NAME_FIELD,purchaseWithoutLogFormModel.getLastName());

        clickSelection(STATE_FIELD);
        Select stateOptions = new Select(STATE_FIELD_ANSWER);
        stateOptions.selectByValue(purchaseWithoutLogFormModel.getState());

        clickSelection(CITY_FIELD);
        Select cityOptions = new Select(CITY_FIELD_ANSWER);
        cityOptions.selectByValue(purchaseWithoutLogFormModel.getCity());

        typeInto(ADDRESS_ONE_FIELD,purchaseWithoutLogFormModel.getAddress());
        typeInto(ADDRESS_TWO_FIELD,purchaseWithoutLogFormModel.getAddress2());
        typeInto(PHONE_NUMBER_FIELD, purchaseWithoutLogFormModel.getPhoneNumber());
    }

    public void chooseDebitCreditCardpayment(){
        waitSeconds(4);
        clickSelection(BALOTO_PAYMENT_METHOD_BUTTON);
    }

    public void confirmTermsConditions(){
        waitSeconds(4);
        clickSelection(TERMS_ACCEPT);
    }

    public void placeOrder(){
        waitSeconds(4);
        clickSelection(PLACE_ORDER_BUTTON);
    }


}
