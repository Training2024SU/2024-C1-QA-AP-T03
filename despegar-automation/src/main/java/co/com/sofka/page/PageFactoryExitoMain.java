package co.com.sofka.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageFactoryExitoMain extends CommonFunctions {
    @CacheLookup()
    @FindBy(xpath = "//input[@placeholder='Buscar en exito.com']")
    private WebElement INPUT_SEARCH;

    @CacheLookup()
    @FindBy(xpath = "(//button[@aria-label='Submit Search'])[1]")
    private WebElement SUBMIT_SEARCH_BTN;

    String SPAN_RESULTS_PIVOT_S = "(//span[text()='Agregar'])[1]";

    private final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public PageFactoryExitoMain(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchItem(String item) {
        INPUT_SEARCH.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        typeInto(INPUT_SEARCH, item);
        clickSelection(SUBMIT_SEARCH_BTN);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SPAN_RESULTS_PIVOT_S)));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SPAN_RESULTS_PIVOT_S)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
