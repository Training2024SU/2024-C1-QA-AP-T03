package co.com.sofka.page;

import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static co.com.sofka.util.util.*;
import static co.com.sofka.util.util.obtenerDiaSemana;

public class DatePickerPage extends FunctionsCommon {

    Date fecha;

    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public DatePickerPage(WebDriver driver, Date fecha) {
        super(driver);
        this.fecha = fecha;
        PageFactory.initElements(driver, this);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @CacheLookup
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement DATE_INPUT;

    @CacheLookup
    @FindBy(className = "react-datepicker__year-select")
    private WebElement CAMPO_YEAR;

    @CacheLookup
    @FindBy(className = "react-datepicker__month-select")
    private WebElement CAMPO_MONTH;

    @CacheLookup
    @FindBy(id = "dateAndTimePickerInput")
    private WebElement DATE_TIME_INPUT;

    @CacheLookup
    @FindBy(className = "react-datepicker__month-read-view")
    private WebElement MONTH_BUTTON;

    private final By YEAR_BUTTOM = By.className("react-datepicker__year-read-view--down-arrow");

    private final By YEAR_OPTIONS = By.className("react-datepicker__year-option");



    public void llenarDatePicker(){
        clickSelection(DATE_INPUT);
        clickSelection(CAMPO_YEAR);
        typeInto(CAMPO_YEAR,obtenerYear(fecha));
        clickSelection(CAMPO_YEAR);
        clickSelection(CAMPO_MONTH);
        typeInto(CAMPO_MONTH, obtenerNombreMes(fecha));
        clickSelection(CAMPO_MONTH);
        By locator_day = generateDinamicCampoDay(obtenerOrdinal(fecha.getDate()),
                obtenerNombreMes(fecha),
                obtenerYear(fecha),
                obtenerDiaSemana(fecha));
        ewait.until(ExpectedConditions.elementToBeClickable(locator_day));
        clickSelection(locator_day);
    }

    public void llenarDateTimePicker(Date fecha){
        scrollTo(DATE_TIME_INPUT);
        clickSelection(DATE_TIME_INPUT);
        clickOptionYear(obtenerYear(fecha));
        clickOptionMonth(obtenerNombreMes(fecha));
        clickOptionDay(fecha);
        clickSelection(hourOption(obtenerHora(fecha)));

    }

    public String removeSymbol(String text) {
        return text.replaceAll("\\u2713", "");
    }


    public void clickOptionMonth(String month){
        clickSelection(MONTH_BUTTON);
        clickSelection(monthOption(month));
    }

    public void clickOptionYear(String year) {
        clickSelection(YEAR_BUTTOM);
        Boolean flag = false;
        int yearInt = Integer.parseInt(year);
        int sizeYearOptions = returnLengthXpath(YEAR_OPTIONS);

        while (flag != true) {
            List<WebElement> yearOptions = findElements(YEAR_OPTIONS);
            int firstYearOption = Integer.parseInt(removeSymbol(getAttributeTextElementContent(yearOptions.get(1))));
            int lastYearOption = Integer
                    .parseInt(removeSymbol(getAttributeTextElementContent(yearOptions.get(sizeYearOptions - 2))));
            if ((yearInt >= lastYearOption) && ((Integer.parseInt(year)) <= firstYearOption)) {
                for (int i = 1; i < sizeYearOptions - 1; i++) {
                    if ((year).equals(removeSymbol(getAttributeTextElementContent(yearOptions.get(i))))) {
                        clickSelection(yearOptions.get(i));
                        flag = true;
                        break;
                    }
                }
            } else {
                if (yearInt < lastYearOption) {
                    clickSelection(yearOptions.get(sizeYearOptions - 1));
                } else {
                    if (yearInt > firstYearOption) {
                        clickSelection(yearOptions.get(0));
                    }
                }
            }
        }
    }

    public void clickOptionDay(Date fecha){
        By locator_day = generateDinamicCampoDay(obtenerOrdinal(fecha.getDate()),
                obtenerNombreMes(fecha),
                obtenerYear(fecha),
                obtenerDiaSemana(fecha));
        ewait.until(ExpectedConditions.elementToBeClickable(locator_day));
        clickSelection(locator_day);
    }

    public By monthOption(String month) {
       return By.xpath("//div[@class='react-datepicker__month-dropdown']//div[text()='"+month+"']");
    }

    public By hourOption(String hour) {
        return By.xpath("//li[contains(@class,'react-datepicker__time-list-item') and contains(text(),'"+hour+"')]");
    }

    private By generateDinamicCampoDay(String num,String month,String year,String day) {

        String selector = "div[aria-label='Choose "+day+", "+month+" "+num+", "+year+"']";

        return  By.cssSelector(selector);
    }


}
