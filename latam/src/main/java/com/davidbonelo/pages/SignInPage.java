package com.davidbonelo.pages;

import com.davidbonelo.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends BasePage {
    @FindBy(id = "secondary-button")
    WebElement signUpBtn;
    @FindBy(id = "form-input--alias")
    WebElement emailField;
    @FindBy(id = "form-input--alias-helper-text")
    WebElement fieldErrorDiv;
    //    @FindBy(css = ".xp-Alert-Title")
//    WebElement alertErrorDiv;
    @FindBy(css = "div h4")
    WebElement alertErrorDiv;
    @FindBy(id = "primary-button")
    WebElement continueBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(User user) {
        emailField.sendKeys(user.getEmail());
        continueBtn.click();
    }

    public void sendNotRegisteredEmail(User user) {
        emailField.sendKeys(user.getEmail());
        continueBtn.click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(alertErrorDiv));
        return alertErrorDiv.getText();
    }
}
