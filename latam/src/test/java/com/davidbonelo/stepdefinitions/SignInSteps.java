package com.davidbonelo.stepdefinitions;

import com.davidbonelo.models.User;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.SignInPage;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.davidbonelo.setup.WebSetup.BASE_URL;

public class SignInSteps {
    private final WebSetup webSetup;
    private SignInPage signInPage;

    public SignInSteps(WebSetup webSetup) {
        this.webSetup = webSetup;
    }

    @Given("The user is in the login page")
    public void theUserIsInTheLoginPage() {
        HomePage homePage = new HomePage(webSetup.driver);
        signInPage = homePage.navigateToSignInPage();
    }

    @When("he accedes with his correct credentials")
    public void heAccedesWithHisCorrectCredentials() {
        User user = User.createFakeUser();
        signInPage.sendEmail(user);
    }

    @Then("he should be redirected to the home page")
    public void heShouldBeRedirectedToTheHomePage() {
        System.out.println();
        String assertionMsg = "The url doesn't match the home page";
        Assertions.assertEquals(BASE_URL, webSetup.driver.getCurrentUrl(), assertionMsg);
    }

    @Given("he tries to access with a new email")
    public void heTriesToAccessWithANewEmail() {
        User user = User.createFakeUser();
        signInPage.sendNotRegisteredEmail(user);
    }

    @Then("he should see an error message appear")
    public void heShouldSeeAnErrorMessageAppear() {
        String errMsg = "No pudimos iniciar sesión";
        Assertions.assertEquals(errMsg, signInPage.getErrorMessage());
    }
}
