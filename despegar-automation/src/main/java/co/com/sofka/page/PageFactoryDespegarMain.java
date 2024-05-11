package co.com.sofka.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageFactoryDespegarMain extends CommonFunctions{
    @CacheLookup
    @FindBy(xpath = "//a[@title='Vuelos']//div[@class='button-content']")
    private WebElement FLY_REDIRECT_BTN;



    public PageFactoryDespegarMain(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToFlies(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        clickSelection(FLY_REDIRECT_BTN);
    }
}

