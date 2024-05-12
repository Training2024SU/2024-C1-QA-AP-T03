package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EquipajePage extends FunctionsCommon {

    public EquipajePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(id = "button-cart-confirm")
    private WebElement BOTON_CONTINUAR_EQUIPAJE;

    @CacheLookup
    @FindBy(id = "BAGS-continue-button")
    private WebElement BAGS_BUTTON;

    public void continuarSinEquipaje() throws InterruptedException {
        try {
            esperarClickable(BAGS_BUTTON);
            clickSelection(BAGS_BUTTON);
        }catch (Exception e){
            System.out.println("no hizo falta");
        }
        esperarClickable(BOTON_CONTINUAR_EQUIPAJE);

        clickSelection(BOTON_CONTINUAR_EQUIPAJE);
    }


}
