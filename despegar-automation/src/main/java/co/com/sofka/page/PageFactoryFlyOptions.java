package co.com.sofka.page;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class PageFactoryFlyOptions extends CommonFunctions{
    // Confirm cookies
    @CacheLookup
    @FindBy(xpath = "//em[normalize-space()='Entendí']")
    private WebElement CONFIRM_COOKIES_BTN;

    @CacheLookup
    @FindAll(@FindBy(xpath = "//span[@class = 'amount price-amount' ]/ancestor::li[contains(@class, 'priceItem')]"))
    private List<WebElement> AIRLINE_OPTIONS;

    public PageFactoryFlyOptions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void confirmCookies(){
        clickSelection(CONFIRM_COOKIES_BTN);
    }

    public void selectRandomAirline(){
        Random random = new Random();
        System.out.println(AIRLINE_OPTIONS);
        int index = random.nextInt(1, AIRLINE_OPTIONS.size());
        clickSelection(AIRLINE_OPTIONS.get(index));
    }

}

