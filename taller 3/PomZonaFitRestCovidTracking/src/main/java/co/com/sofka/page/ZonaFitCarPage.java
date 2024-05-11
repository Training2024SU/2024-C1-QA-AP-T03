package co.com.sofka.page;

import co.com.sofka.page.Functions.FunctionCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZonaFitCarPage extends FunctionCommons {

    @CacheLookup
    @FindBy(xpath = "(//*[@type='button'and @value ='+'])[1]")
    private WebElement INCREASE_AMOUNT_BOTON_ONE;

    @CacheLookup
    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    private WebElement CONFIRM_PURCHASE_BUTON;

    public ZonaFitCarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void increaseAmountProducts(){
        waitSeconds(3);
        clickSelection(INCREASE_AMOUNT_BOTON_ONE);
    }

    public void confirmCar(){
        waitSeconds(4);
        CONFIRM_PURCHASE_BUTON = driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']"));
        scrollTo(CONFIRM_PURCHASE_BUTON);
        waitSeconds(3);
        CONFIRM_PURCHASE_BUTON = driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']"));
        clickSelection(CONFIRM_PURCHASE_BUTON);
    }
}
