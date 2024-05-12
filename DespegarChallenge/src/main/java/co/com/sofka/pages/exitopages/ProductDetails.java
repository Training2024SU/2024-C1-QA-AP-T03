package co.com.sofka.pages.exitopages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails extends CommonFunctions {
    //(//button/span[text()='Agregar'])[1]
    @CacheLookup
    @FindBy(xpath = "//div[@data-fs-container-buybutton='true']/button[@class='DefaultStyle_default__jW12W ']")
    private WebElement addButton;
    @CacheLookup
    @FindBy(className = "QuantitySelectorDefault_plus__1LAkq")
    private WebElement plusButton;
    @CacheLookup
    @FindBy(xpath = "//button[@data-testid='cart-toggle']")
    private WebElement cartButton;
    @CacheLookup
    @FindBy(xpath = "//a[@title='Volver al inicio']")
    private WebElement goHomePageButton;
    public ProductDetails(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProducts(int productQuantity){
        waitToBeVisible(addButton);
        wait(3);
        click(addButton);
        waitToBeVisible(plusButton);
        for (int i = 0; i < productQuantity-1; i++) {
            click(plusButton);
        }
    }
    public void goToCart(){
        click(cartButton);
    }
}
