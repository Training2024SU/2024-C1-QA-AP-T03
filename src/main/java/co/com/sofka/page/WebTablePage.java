package co.com.sofka.page;

import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage extends FunctionsCommon {

    public WebTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement ADD_BUTTON;




}
