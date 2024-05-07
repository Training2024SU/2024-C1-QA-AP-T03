package co.com.sofka.page;

import co.com.sofka.util.CalendarConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class PageFactoryFly extends CommonFunctions {

    // from to
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Ingresa desde dónde viajas'])[1]")
    private WebElement ORIGIN_INPUT;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Ingresa hacia dónde viajas'])[1]")
    private WebElement DESTINY_INPUT;


    String MONTH_OPTION = "(//div[@class='sbox5-monthgrid-title-month'])[1]";
    String DYNAMIC_DAY_OPTION = "(//div[@class = 'sbox5-monthgrid']//div[text() = '%s'])[1]";


    // Calendar pop up
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Ida']")
    private WebElement INPUT_FROM;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Vuelta'])[1]")
    private WebElement INPUT_BACK;

    @CacheLookup
    @FindBy(xpath = "(//a[@class='calendar-arrow-right '])[1]")
    private WebElement RIGHT_BTN;
    @CacheLookup
    @FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//em[@class='btn-text'][normalize-space()='Aplicar']")
    private WebElement ACCEPT_DATE_BTN;

    // passengers
    @CacheLookup
    @FindBy(xpath = "(//div[@class='sbox5-distributionPassengers']//input)[1]")
    private WebElement INPUT_PASSENGERS;

    @CacheLookup
    @FindBy(xpath = "(//button[@class = 'steppers-icon-right stepper__icon'])[1]")
    private WebElement INCREASE_NUMBER_PASSENGERS_BTN;
    @CacheLookup
    @FindBy(xpath = "//a[@class = 'sbox5-3-btn -md -primary']")
    private WebElement CONFIRM_NUMBER_PASSENGERS_BTN;


    private final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    public PageFactoryFly(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void selectSource(String source) {
        cleanField(ORIGIN_INPUT);
        typeInto(ORIGIN_INPUT, source);
    }

    public void selectTarget(String target) {
        cleanField(DESTINY_INPUT);
        typeInto(DESTINY_INPUT, target);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER);
    }

    public void selectFromDate(Integer fromYear, Integer fromMonth, Integer fromDay) {
        clickSelection(INPUT_FROM);
        wait.until(d -> ACCEPT_DATE_BTN.isDisplayed());
        selectMonthDay(fromMonth, fromDay);
    }

    public void selectToDate(Integer toYear, Integer toMonth, Integer toDay) {
        clickSelection(INPUT_BACK);
        wait.until(d -> ACCEPT_DATE_BTN.isDisplayed());
        selectMonthDay(toMonth, toDay);
    }

    private void selectMonthDay(Integer toMonth, Integer toDay) {
        for (int i = 0; i < 12; i++) {
            String targetMonth = getText(driver.findElement(By.xpath(MONTH_OPTION)));
            if (targetMonth.equals(CalendarConstants.months.get(toMonth))) {
                clickSelection(By.xpath(String.format(DYNAMIC_DAY_OPTION, toDay)));
                return;
            } else {
                clickSelection(RIGHT_BTN);
            }
        }
    }

    public void selectPassengers(Integer passengers) {
        clickSelection(INPUT_PASSENGERS);
        wait.until(d -> CONFIRM_NUMBER_PASSENGERS_BTN.isDisplayed());
        while (passengers > 1){
            clickSelection(INCREASE_NUMBER_PASSENGERS_BTN);
            passengers--;
        }
        clickSelection(CONFIRM_NUMBER_PASSENGERS_BTN);
    }


    public void confirmDate() {
        clickSelection(ACCEPT_DATE_BTN);
    }
}
