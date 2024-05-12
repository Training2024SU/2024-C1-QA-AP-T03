package co.com.sofka.pages.exitopages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//a[text()='Nevera SAMSUNG No Frost Congelador Superior 236 LTS RT22FARADS8CO Gris Claro']")
    private WebElement refrigeratorSelected;
    public SearchResults(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void selectProducts(String productName){
        waitToBeVisible(selectProduct(productName));
        click(refrigeratorSelected);
    }

    private WebElement selectProduct(String productName){
        String xpath="//a[contains(text(),'%s')]";
        String xpathFormatted=String.format(xpath, productName);
        return driver.findElement(By.xpath(xpathFormatted));
    }
}
