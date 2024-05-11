package co.com.sofka.page;

import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultadoVueloPage extends FunctionsCommon {
    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(15));


    private String origen;
    private String destino;


    public ResultadoVueloPage(WebDriver driver,String origen,String destino) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.origen = origen;
        this.destino = destino;
    }

    @CacheLookup
    @FindBy(className = "landingTitle")
    private WebElement CAMPO_TITTLE;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Ordenar por')]/ancestor::div[@id='order']//select")
    private WebElement SELECT_ORDENAR;

    @CacheLookup
    @FindBy(xpath = "//option[contains(@value,'duration_ascending')]")
    private WebElement OPTIONDURATION;

    public void ordenarVueloPorDuracion(){
       scrollTo(SELECT_ORDENAR);
       clickSelection(SELECT_ORDENAR);
       clickSelection(OPTIONDURATION);
        System.out.println("Hecho");
    }

    public Boolean verificarOrigenDestino(){
       String comute =  getText(CAMPO_TITTLE);
       Boolean origenVer = comute.contains(origen);
        Boolean destinoVer = comute.contains(destino);
        ewait.until(ExpectedConditions.visibilityOf(CAMPO_TITTLE));
        return (origenVer && destinoVer);

    }
    public String verificarOrigen(){
        String comute =  getText(CAMPO_TITTLE);
        boolean origenVer = comute.contains(origen);
        if(origenVer){
            ewait.until(ExpectedConditions.visibilityOf(CAMPO_TITTLE));
            return origen;
        }else{
            return null;
        }
    }

    public String verificarDestino(){
        String comute =  getText(CAMPO_TITTLE);
        boolean destinoVer = comute.contains(destino);
        if(destinoVer){
            ewait.until(ExpectedConditions.visibilityOf(CAMPO_TITTLE));
            return destino;
        }else{
            return null;
        }
    }








}
