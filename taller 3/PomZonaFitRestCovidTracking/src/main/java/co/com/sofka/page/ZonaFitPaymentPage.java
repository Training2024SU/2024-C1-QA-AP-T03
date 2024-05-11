package co.com.sofka.page;

import co.com.sofka.page.Functions.FunctionCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZonaFitPaymentPage extends FunctionCommons {

    @CacheLookup
    @FindBy(xpath = "//*[text() = 'CONVENIO RECAUDO ZONA FIT – BALOTO']")
    private WebElement ASSERTION_TEXTO;

    public ZonaFitPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String conseguirTextoAssertion(){
        waitSeconds(15);
        return getText(ASSERTION_TEXTO);
    }
}
