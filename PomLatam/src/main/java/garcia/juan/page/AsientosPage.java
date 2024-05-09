package garcia.juan.page;

import garcia.juan.page.function.FunctionsCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AsientosPage extends FunctionsCommon {

    protected final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    public AsientosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }



}
