package co.com.sofka.pages.exitopages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonFunctions {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Buscar en exito.com']")
    private WebElement searchInput;
    @CacheLookup
    @FindBy(xpath = "(//button[@aria-label='Submit Search'])[1]")
    private WebElement searchButton;
    @CacheLookup
    @FindBy(id = "wps-overlay-close-button")
    private WebElement adCloseButton;
    @CacheLookup
    @FindBy(xpath = "//a[@title='Volver al inicio']")
    private WebElement goHomePageButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProducts(String product1) throws InterruptedException {
        isElementDisplayed(searchInput);
        click(searchInput);
        wait(5);
        typeInto(searchInput, product1);
        wait(5);
        click(searchButton);

        try {
            isElementDisplayed(adCloseButton);
            click(adCloseButton);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectCategories(String categoryName) {
        isElementDisplayed(goHomePageButton);
        scrollTo(selectCategory(categoryName));
        click(selectCategory(categoryName));
    }

    private WebElement selectCategory(String categoryName) {
        String xpath = "//p[text()='%s']";
        String xpathFormatted = String.format(xpath, categoryName);
        return driver.findElement(By.xpath(xpathFormatted));
    }

}
