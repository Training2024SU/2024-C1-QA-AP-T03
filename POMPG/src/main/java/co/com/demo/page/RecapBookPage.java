package co.com.demo.page;

import co.com.demo.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RecapBookPage extends CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public RecapBookPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "")
    private WebElement fare;

    @CacheLookup
    @FindBy(id = "")
    private WebElement changeFlight;

    @CacheLookup
    @FindBy(id = "")
    private WebElement redirectSeatsSelection;
}
