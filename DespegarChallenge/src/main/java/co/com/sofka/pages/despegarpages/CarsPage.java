package co.com.sofka.pages.despegarpages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CarsPage extends CommonFunctions {

    public CarsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
