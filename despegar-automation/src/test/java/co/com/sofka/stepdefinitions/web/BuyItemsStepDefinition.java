package co.com.sofka.stepdefinitions.web;

import co.com.sofka.model.ExitoAddressModel;
import co.com.sofka.model.ExitoUserModel;
import co.com.sofka.page.PageFactoryExitoCart;
import co.com.sofka.page.PageFactoryExitoForm;
import co.com.sofka.page.PageFactoryExitoItems;
import co.com.sofka.page.PageFactoryExitoMain;
import co.com.sofka.setup.web.WebBrowser;
import co.com.sofka.setup.web.WebPage;
import co.com.sofka.setup.web.WebSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;

import java.util.List;
import java.util.Map;

import static co.com.sofka.util.ModelFactory.mapDataTableToAddressModels;
import static co.com.sofka.util.ModelFactory.mapDataTableToUserModels;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class BuyItemsStepDefinition extends WebSetup {
    private PageFactoryExitoItems pageFactoryExitoItems;
    private PageFactoryExitoForm pageFactoryExitoForm;

    @Given("the user is on the exito.com platform using {string}")
    public void theUserIsOnTheExitoComPlatformUsing(String webDriver) {
        generalSetup(WebBrowser.valueOf(webDriver), WebPage.EXITO);
    }

    @When("adds the following items to the cart")
    public void addsTheFollowingItemsToTheCart(List<String> items) {
        PageFactoryExitoMain pageFactoryExitoMain = new PageFactoryExitoMain(driver);
        pageFactoryExitoItems = new PageFactoryExitoItems(driver);

        items.forEach(item -> {
            pageFactoryExitoMain.searchItem(item);
            pageFactoryExitoItems.addItem();
        });
        pageFactoryExitoItems.goToCart();

    }

    @When("confirms their credentials")
    public void confirmsTheirCredentials(List<Map<String, String>> dataTable) {
        Faker faker = new Faker();
        ExitoUserModel exitoUserModel = mapDataTableToUserModels(dataTable).get(0);
        exitoUserModel.setEmail(faker.bothify("###") + exitoUserModel.getEmail());
        ExitoAddressModel exitoAddressModel = mapDataTableToAddressModels(dataTable).get(0);
        PageFactoryExitoCart pageFactoryExitoCart = new PageFactoryExitoCart(driver);
        pageFactoryExitoForm = new PageFactoryExitoForm(driver);
        pageFactoryExitoCart.confirmItems();
        pageFactoryExitoCart.submitEmail(exitoUserModel.getEmail());
        pageFactoryExitoForm.fillUserData(exitoUserModel, exitoAddressModel);
    }

    @Then("should receive a confirmation message indicating a successful purchase")
    public void shouldReceiveAConfirmationMessageIndicatingASuccessfulPurchase() {
        String expectedText = "Total";
        String actualText = pageFactoryExitoForm.getLastTextButton();
        System.out.println(actualText);
        assertThat(actualText, containsString(expectedText));
    }
    @After
    public void tearDown() {
        quitDriver();
    }

}
