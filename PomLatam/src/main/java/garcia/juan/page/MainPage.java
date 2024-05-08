package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends FunctionsCommon {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Selectors

    @CacheLookup
    @FindBy(css = "button[data-testid='cookies-politics-button--button']\n")
    private WebElement COOKIES_BUTTON;

    @CacheLookup
    @FindBy(id = "txtInputOrigin_field")
    private WebElement ORIGEN_INPUT;

    @CacheLookup
    @FindBy(id = "lstItem_0")
    private WebElement ORIGEN_AUTO;

    @CacheLookup
    @FindBy(id = "txtInputDestination_field")
    private WebElement DESTINO_INPUT;

    //Methods
    public void acceptCookies (){
        clickSelection(COOKIES_BUTTON);

    }

    public void insertOrigenAndDestino(String origen,String destino){
        //clickSelection(ORIGEN_INPUT);
        typeInto(ORIGEN_INPUT,"Lima");
        //typeInto(DESTINO_INPUT,destino);
        //clickSelection(ORIGEN_AUTO);
    }

}
