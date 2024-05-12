package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortablePage extends FunctionsCommon {
    // constructor
    public SortablePage(WebDriver driver) {
        super(driver);
    }

    // localizador
    private final By CAMPO_LIST = By.id("demo-tab-list");
    private final By ELEMENTO_ONE = By.xpath("//*[contains(@class,'vertical-list-container')]//*[text()='One']");
    private final By ELEMENTO_FIVE = By.xpath("//*[contains(@class,'vertical-list-container')]//*[text()='Five']");


    // funciones
    public void moverElemento(){
        scrollTo(CAMPO_LIST);
        mantenerMover(ELEMENTO_ONE,ELEMENTO_FIVE);
    }

}
