package co.com.demo.page;

import co.com.demo.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PassengerInformationPage extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public PassengerInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "")
    private WebElement name;

    @CacheLookup
    @FindBy(id = "")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "")
    private WebElement dateOfBirth;

    @CacheLookup
    @FindBy(id = "")
    private WebElement gender;

    @CacheLookup
    @FindBy(id = "")
    private WebElement country;

    @CacheLookup
    @FindBy(id = "")
    private WebElement identification;

    @CacheLookup
    @FindBy(id = "")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "")
    private WebElement phoneNumber;

    @CacheLookup
    @FindBy(id = "")
    private WebElement confirmInformation;

    @CacheLookup
    @FindBy(id = "")
    private WebElement addContinue;
}
