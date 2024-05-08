package co.com.sofka.page;

import co.com.sofka.util.functions.FunctionsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableroSorteablePage  extends FunctionsCommon {
    // localizadores

    private final By GRID_OPTION = By.id("demo-tab-grid");
    private final By LIST = By.xpath("//div[@class='grid-container mt-4']//div[contains(@class, 'list-group-item') ]");
    private final By AD_CONTAINER = By.id("Ad.Plus-970x250-2");


    private WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private List<WebElement> elementos;

    private List<WebElement> elementosOrgnizados;

    private List<String> ordenOriginal;


    public TableroSorteablePage(WebDriver driver)  {
        super(driver);
    }

    // funciones

    public void obtenerElemementos(){
        scrollTo(AD_CONTAINER);
        clickSelection(GRID_OPTION);
         elementos = driver.findElements(LIST);
        System.out.println(elementos.size());
    }

    public void obtenerElementosOrganizados(){
        scrollTo(AD_CONTAINER);
        elementosOrgnizados = driver.findElements(LIST);
        System.out.println(elementos.size());
    }

    public void organizarElemetos(){
        int size = elementos.size();

        // Crear una lista de índices que representen el orden original de los elementos
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            indices.add(i);
        }

        // Barajar aleatoriamente los índices
        Collections.shuffle(indices);

        //guardar orden original
        ordenOriginal = new ArrayList<>();
        for (WebElement elemento : elementos) {
            ordenOriginal.add(elemento.getText());
        }

        // Mover los elementos según el nuevo orden de los índices
        for (int i = 0; i < size; i++) {
            WebElement elementoActual = elementos.get(i);
            WebElement elementoDestino = elementos.get( indices.get(i));
            clickAndHold(elementoActual,elementoDestino);
        }


    }

    public boolean compararListas(){
        boolean comparation = false;
        for (int i = 0; i < elementos.size(); i++) {
            String elemento = ordenOriginal.get(i);
            WebElement elementoOrganizado = elementosOrgnizados.get(i);
            if (!elemento.equals(elementoOrganizado.getText())) {
                i = elementos.size();
               comparation = true;
            }
        }
        return comparation;
    }

}
