package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends FunctionsCommon {
    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Selectors
    @CacheLookup
    @FindBy(id = "login-wrapper")
    private WebElement LOG_IN_BUTTON;

//Methods
    public void goToLogIn(){
        clickSelection(LOG_IN_BUTTON);
    }

}
