package com.davidbonelo.stepdefinitions;

import com.davidbonelo.models.User;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.SignInPage;
import com.davidbonelo.pages.SignUpPage;
import com.davidbonelo.setup.BrowserType;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignUpSteps {
    private final WebSetup webSetup;
    private SignUpPage signUpPage;

    public SignUpSteps(WebSetup webSetup) {
        this.webSetup = webSetup;
    }

    @Given("the User browses the internet using the {string} browser")
    public void theUserBrowsesTheInternetUsingTheBrowser(String browser) {
        webSetup.setupDriver(BrowserType.valueOf(browser));
    }

    @Given("The user is in the signup page")
    public void theUserIsInTheSignupPage() {
        HomePage homePage = new HomePage(webSetup.driver);
        SignInPage signInPage = homePage.navigateToSignInPage();
        signUpPage = signInPage.navigateToSignUpPage();
    }

    @When("he creates his account with valid information")
    public void heCreatesHisAccountWithValidInformation() {
        User user = User.createFakeUser();
        signUpPage.signUpAs(user);
    }
}
