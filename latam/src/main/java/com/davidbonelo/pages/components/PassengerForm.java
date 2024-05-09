package com.davidbonelo.pages.components;

import com.davidbonelo.models.User;
import com.davidbonelo.models.enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PassengerForm extends BaseComponent {

    private final int index;
    private final WebDriverWait wait;
    private WebElement lastNameField;
    private WebElement firstNameField;
    private WebElement birthDateField;
    private WebElement documentField;
    private WebElement emailField;
    private WebElement phoneField;
    private WebElement submitBtn;

    public PassengerForm(WebElement root, int index, WebDriverWait wait) {
        super(root);
        this.index = index + 1;
        this.wait = wait;
    }

    private void initializeLocators() {
        // The form div is actually the sibling of this root
        By formLocator = By.xpath("./following-sibling::div");
        WebElement form = root.findElement(formLocator);

        firstNameField = form.findElement(By.id("passengerDetails-firstName-ADT_" + index));
        lastNameField = form.findElement(By.id("passengerDetails-lastName-ADT_" + index));
        birthDateField = form.findElement(By.id("passengerInfo-dateOfBirth-ADT_" + index));
        documentField = form.findElement(By.id("documentInfo-documentNumber-ADT_" + index));
        emailField = form.findElement(By.id("passengerInfo-emails-ADT_" + index));
        phoneField = form.findElement(By.id("passengerInfo-phones0-number-ADT_" + index));
        submitBtn = form.findElement(By.id("passengerFormSubmitButtonADT_" + index));
    }

    public void fillData() {
        User user = User.createFakeUser();
        expand();
        initializeLocators();
        typeInto(firstNameField, user.getName());
        typeInto(lastNameField, user.getLastName());
        typeInto(birthDateField, formatDate(user.getBirthDate()));
        selectGender(user.getGender());
        typeInto(documentField, user.getId());
        typeInto(emailField, user.getEmail());
        typeInto(phoneField, user.getPhone());
        clickElement(submitBtn);
        wait.until(d -> !isExpanded()); // wait until save
    }

    private void selectGender(Gender gender) {
        By genderDropdown = By.xpath("//div[@id='mui-component-select-passengerInfo.gender']");
        if (gender == Gender.FEMALE) {
            wait.until(ExpectedConditions.elementToBeClickable(genderDropdown)).click();
            By genderLocator = By.xpath("//li[text()='Femenino']");
            wait.until(ExpectedConditions.elementToBeClickable(genderLocator)).click();
        }
    }

    private String formatDate(LocalDate birthDate) {
        return birthDate.format(DateTimeFormatter.ofPattern("ddMMuuuu"));
    }

    private void expand() {
        if (isExpanded()) return;
        root.click();
    }

    public boolean isExpanded() {
        return Objects.equals(root.getAttribute("aria-expanded"), "true");
    }
}
