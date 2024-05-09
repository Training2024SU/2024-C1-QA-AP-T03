package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetodoPagoPage extends FunctionsCommon {

    @CacheLookup
    @FindBy(id = "new-credit-card-payment-method")
    private WebElement CREDIT_CARD;

    @CacheLookup
    @FindBy(id = "cardNumber--text-field")
    private WebElement NUMERO_CARD;

    @CacheLookup
    @FindBy(id = "cardHolder--text-field")
    private WebElement NOMBRE_CARD;

    @CacheLookup
    @FindBy(id = "expirationDate--text-field")
    private WebElement DATE_CARD;

    @CacheLookup
    @FindBy(id = "CVV--password__input--text-field")
    private WebElement CVV_CARD;


    public MetodoPagoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void seleccionarTarjeta(io.cucumber.datatable.DataTable dataTable){
        esperarClickable(CREDIT_CARD);
        clickSelection(CREDIT_CARD);
        typeInto(NUMERO_CARD, dataTable.cell(1,0));
        typeInto(NOMBRE_CARD, dataTable.cell(1,1));
        typeInto(DATE_CARD, dataTable.cell(1,2));
        esperarClickable(CVV_CARD);
        typeInto(CVV_CARD, dataTable.cell(1,3));

    }

}
