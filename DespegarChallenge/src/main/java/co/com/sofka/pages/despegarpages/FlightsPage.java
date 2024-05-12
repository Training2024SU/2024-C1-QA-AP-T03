package co.com.sofka.pages.despegarpages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//a[@class='-md eva-3-btn -primary'][1]")
    private WebElement buyButton;

    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFlight(){
        click(buyButton);
    }

}
