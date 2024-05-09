package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VuelosDisponiblesPage extends FunctionsCommon {

    protected final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public VuelosDisponiblesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //private final By areaLocator = By.cssSelector("div[aria-expanded='false']");

    @CacheLookup
    @FindBy(id = "WrapperCardFlight0")
    private WebElement VUELO_RECOMENDADO;

    public void clickVueloRecomendado() throws InterruptedException {
        Thread.sleep(15000);
        scrollTo(VUELO_RECOMENDADO);
        clickSelection(VUELO_RECOMENDADO);
    }


}
