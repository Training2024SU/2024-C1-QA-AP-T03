package co.com.sofka.pages.exitopages;

import co.com.sofka.pages.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CellPhonesCategoryPage extends CommonFunctions {
    public CellPhonesCategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void selectCellPhones(String cellPhoneName){
        waitToBeVisible(selectCellPhone(cellPhoneName));
        click(selectCellPhone(cellPhoneName));
    }
    private WebElement selectCellPhone(String cellPhoneName){
        String xpath="//a[text()='%s']";
        String formattedString = String.format(xpath, cellPhoneName);
        return driver.findElement(By.xpath(formattedString));
    }
}
