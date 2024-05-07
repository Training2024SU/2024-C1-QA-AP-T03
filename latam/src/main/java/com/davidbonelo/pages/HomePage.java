package com.davidbonelo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "header__profile__lnk-sign-in")
    private WebElement signInBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage navigateToSignInPage() {
        signInBtn.click();
        return new SignInPage(driver);
    }
}
