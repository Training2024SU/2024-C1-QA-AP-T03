package co.com.sofka.stepdefinitions;


import co.com.sofka.pages.exitopages.HomePage;
import co.com.sofka.pages.exitopages.ProductDetails;
import co.com.sofka.pages.exitopages.SearchResults;
import co.com.sofka.setup.ExitoWebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class PurchaseDifferentProductsStepDefinitions extends ExitoWebSetUp {
    HomePage homePage;
    SearchResults searchResults;
    ProductDetails productDetails;

    @Given("the user is in the web page {int}")
    public void theUserIsInTheWebPage(Integer driverType) {
        try {
            generalSetUp(driverType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

    @Given("adds to cart refrigerator {string} {int} washing machine {string} {int} and blender {string} {int}")
    public void addsToCartRefrigeratorWashingMachineAndBlender(String product1, Integer productQuantity1, String product2, Integer int2, String string3, Integer int3) {
        try {
            homePage = new HomePage(driver);
            searchResults = new SearchResults(driver);
            productDetails =new ProductDetails(driver);
            homePage.searchProducts(product1);
            searchResults.selectProducts(product1);
            productDetails.addProducts(productQuantity1);
            Thread.sleep(100000);
            homePage.searchProducts(product2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }
    }

    @When("proceeds to finalize the purchase")
    public void proceedsToFinalizeThePurchase() {

    }

    @Then("should see a confirmation message")
    public void shouldSeeAConfirmationMessage() {

    }

}
