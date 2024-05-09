package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasajeroFormPage extends FunctionsCommon {



    private String LASTNAME = "passengerDetails-lastName-ADT_1";
    private String BIRTHDAY="passengerInfo-dateOfBirth-ADT_1";
    private String GENDER = "//li[contains(text(), '%s')]";

    @CacheLookup
    @FindBy(id = "passengerDetails-firstName-ADT_1")
    private WebElement FIRSTNAME;

    @CacheLookup
    @FindBy(id = "documentInfo-documentNumber-ADT_1")
    private WebElement DOCUMENT;

    @CacheLookup
    @FindBy(id = "passengerInfo-emails-ADT_1")
    private WebElement EMAIL;

    @CacheLookup
    @FindBy(id = "mui-component-select-passengerInfo.gender")
    private WebElement SELECT_GENDER;

    @CacheLookup
    @FindBy(id = "passengerInfo-phones0-number-ADT_1")
    private WebElement NUMERO;

    @CacheLookup
    @FindBy(id = "passengerFormSubmitButtonADT_1")
    private WebElement CONFIRMAR;

    @CacheLookup
    @FindBy(id = "undefined--button-wrapper")
    private WebElement CONTINUAR_FORM;

    public PasajeroFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void llenarFormulario(int pasajeros,io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        esperarClickable(FIRSTNAME);
        for (int i =1;i<=pasajeros;i++){
            typeInto(FIRSTNAME,dataTable.cell(i,0));
            typeInto(By.id(LASTNAME),dataTable.cell(i,1));
            typeInto(By.id(BIRTHDAY),dataTable.cell(i,2));
            clickSelection(SELECT_GENDER);
            clickSelection(By.xpath(String.format(GENDER,dataTable.cell(i,3))));
            scrollTo(DOCUMENT);
            typeInto(DOCUMENT, dataTable.cell(i,6));
            scrollTo(EMAIL);
            typeInto(EMAIL, dataTable.cell(i,7));
            scrollTo(NUMERO);
            typeInto(NUMERO, dataTable.cell(i,9));
            esperarClickable(CONFIRMAR);
            clickSelection(CONFIRMAR);
            Thread.sleep(6000);//este es ara que confirme el usuario
        }
    }

    public void pasarAPago(){
        esperarClickable(CONTINUAR_FORM);
        clickSelection(CONTINUAR_FORM);
    }
}
