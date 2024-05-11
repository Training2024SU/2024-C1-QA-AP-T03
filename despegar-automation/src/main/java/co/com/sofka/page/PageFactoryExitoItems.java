package co.com.sofka.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PageFactoryExitoItems extends CommonFunctions{
    private String ADD_CART_OPTIONS_BTN = "//button[@class = 'DefaultStyle_default__jW12W ']";

    @CacheLookup
    @FindBy(xpath = "//div[@data-fs-navbar-minicart-icon-container='true']")
    WebElement CART_BTN;


    private final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    public PageFactoryExitoItems(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItem() {
        List<WebElement> itemsList = driver.findElements(By.xpath(ADD_CART_OPTIONS_BTN));
        Random random = new Random();
        int index = random.nextInt(itemsList.size() / 2);
        clickSelection(itemsList.get(index));
    }


    public void goToCart(){
        clickSelection(CART_BTN);
    }
}
