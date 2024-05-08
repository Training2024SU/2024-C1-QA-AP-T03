package com.davidbonelo.pages;

import com.davidbonelo.models.User;
import com.davidbonelo.models.enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SignUpPage extends BasePage {
    private WebElement documentCode;
    private WebElement name;
    private WebElement lastName;
    private WebElement birthDate;
    private WebElement contactCode;
    private WebElement email;
    private WebElement password;
    private WebElement termsAndConditions;
    private WebElement privacyPolicy;
    private WebElement submit;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUpAs(User user) {
        documentCode.sendKeys(user.getId());
        name.sendKeys(user.getName());
        lastName.sendKeys(user.getLastName());
        fillBirthDate(user.getBirthDate());
        selectGender(user.getGender());
        contactCode.sendKeys(user.getPhone());
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        termsAndConditions.click();
        privacyPolicy.click();
        submit.click();
    }

    private void fillBirthDate(LocalDate date) {
        birthDate.sendKeys(date.format(DateTimeFormatter.ofPattern("ddMMuuuu")));
    }

    private void selectGender(Gender gender) {
        switch (gender) {
            case MALE, FEMALE, OTHER -> clickElement(By.id(gender.getHtmlId()));
            default -> throw new IllegalStateException("Unexpected gender value: " + gender);
        }
    }
}
