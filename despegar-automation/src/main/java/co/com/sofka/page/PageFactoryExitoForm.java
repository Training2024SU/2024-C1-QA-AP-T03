package co.com.sofka.page;

import co.com.sofka.model.ExitoAddressModel;
import co.com.sofka.model.ExitoUserModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PageFactoryExitoForm extends CommonFunctions {
    @CacheLookup
    @FindBy(css = "input[type='email']")
    WebElement EMAIL_INPUT;

    @CacheLookup
    @FindBy(css = "input[name='firstName']")
    WebElement NAME_INPUT;

    @CacheLookup
    @FindBy(css = "input[name='lastName']")
    WebElement LASTNAME_INPUT;

    @CacheLookup
    @FindBy(css = "input[name='document']")
    WebElement DOCUMENT_INPUT;

    @CacheLookup
    @FindBy(css = "input[name='phone']")
    WebElement PHONE_INPUT;

    @CacheLookup
    @FindAll(@FindBy(css = "input[type='checkbox']"))
    List<WebElement> CHECKBOXES_INPUT;

    @CacheLookup
    @FindBy(xpath = "//button[@data-atom-button='true']")
    WebElement SUBMIT_DATA_BTN;


    @CacheLookup
    @FindAll(@FindBy(xpath = "//select[@name = 'state']/option"))
    List<WebElement> STATES_OPTIONS;

    @CacheLookup
    @FindAll(@FindBy(xpath = "//select[@name = 'city']/option"))
    List<WebElement> CITY_OPTIONS;

    @CacheLookup
    @FindAll(@FindBy(xpath = "//select[@name = 'type']/option"))
    List<WebElement> TYPE_OPTIONS;

    @CacheLookup
    @FindBy(xpath = "//input[@name = 'mainAddress']")
    WebElement ADDRESS_MAIN_INPUT;

    @CacheLookup
    @FindBy(xpath = "//input[@name = 'firstNumber']")
    WebElement FIRST_NUMBER_INPUT;

    @CacheLookup
    @FindBy(xpath = "//input[@name = 'secondNumber']")
    WebElement SECOND_NUMBER_INPUT;

    @CacheLookup
    @FindBy(xpath = "//input[@name = 'neighborhood']")
    WebElement NEIGHBORHOOD_INPUT;

    @CacheLookup
    @FindBy(xpath = "//input[@name = 'complement']")
    WebElement COMPLEMENT_INPUT;

    @CacheLookup
    @FindBy(xpath = "//input[@name = 'receiverName']")
    WebElement RECEIVER_NAME_INPUT;


    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SUBMIT_ADDRESS_DATA_BTN;


    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(), 'Total')]")
    WebElement END_BTN;


    @CacheLookup
    @FindBy(xpath = "//div[@data-molecule-modal-content = 'true']")
    WebElement DIV_FORM_PIVOT;


    private final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public PageFactoryExitoForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillUserData(ExitoUserModel userModel, ExitoAddressModel exitoAddressModel) {
        basicUserData(userModel);
        waitToBeVisible(CHECKBOXES_INPUT.get(0));
        for (int i = 0; i < 3; i++) {
            clickSelection(CHECKBOXES_INPUT.get(i));
        }
        clickSelection(SUBMIT_DATA_BTN);
        basicAddressData(userModel, exitoAddressModel);
        clickSelection(SUBMIT_ADDRESS_DATA_BTN);
    }


    private void basicAddressData(ExitoUserModel userModel, ExitoAddressModel exitoAddressModel) {
        Random random = new Random();

        try {
            waitToBeClickable(DIV_FORM_PIVOT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int index = random.nextInt(STATES_OPTIONS.size());
        clickSelection(STATES_OPTIONS.get(index));

        index = random.nextInt(CITY_OPTIONS.size());
        clickSelection(CITY_OPTIONS.get(index));

        index = random.nextInt(TYPE_OPTIONS.size());
        clickSelection(TYPE_OPTIONS.get(index));

        typeLetterByLetter(ADDRESS_MAIN_INPUT, exitoAddressModel.getMainAddress());
        typeLetterByLetter(FIRST_NUMBER_INPUT, exitoAddressModel.getNumber().substring(0, exitoAddressModel.getNumber().length() / 2));
        typeLetterByLetter(SECOND_NUMBER_INPUT, exitoAddressModel.getNumber().substring(exitoAddressModel.getNumber().length() / 2));
        typeLetterByLetter(NEIGHBORHOOD_INPUT, exitoAddressModel.getNeighborhood());
        typeLetterByLetter(COMPLEMENT_INPUT, exitoAddressModel.getBuilding());
        typeLetterByLetter(RECEIVER_NAME_INPUT, userModel.getName());
    }

    private void typeLetterByLetter(WebElement webElement, String word) {
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            typeInto(webElement, String.valueOf(character));
            customWait();
        }
    }

    private synchronized void customWait() {
        try {
            wait(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void basicUserData(ExitoUserModel userModel) {

        waitElementsForm();

        while (true) {
            String resultName = fillInput(NAME_INPUT, userModel.getName());
            String resultLastname = fillInput(LASTNAME_INPUT, userModel.getLastName());
            String resulDocument = fillInput(DOCUMENT_INPUT, userModel.getIdNumber());
            String resultPhone = fillInput(PHONE_INPUT, userModel.getPhoneNumber());
            if ((Objects.equals(resultName, userModel.getName())) &&
                    (Objects.equals(resultLastname, userModel.getLastName())) &&
                    (Objects.equals(resulDocument, userModel.getIdNumber())) &&
                    (Objects.equals(resultPhone, userModel.getPhoneNumber()))) {
                return;
            }
        }

    }

    private String fillInput(WebElement NAME_INPUT, String userModel) {
        while (!Objects.equals(NAME_INPUT.getAttribute("value"), userModel)) {
            cleanField(NAME_INPUT);
            clickSelection(NAME_INPUT);
            typeInto(NAME_INPUT, userModel);
            NAME_INPUT.sendKeys(Keys.ENTER);
        }
        return NAME_INPUT.getAttribute("value");
    }

    private void waitElementsForm() {
        waitToBeClickable(NAME_INPUT);
        waitToBeClickable(LASTNAME_INPUT);
        waitToBeClickable(DOCUMENT_INPUT);
        waitToBeClickable(PHONE_INPUT);
    }

    public String getLastTextButton() {
        try {
            waitToBeClickable(END_BTN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return getText(END_BTN);
    }
}
