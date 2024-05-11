package co.com.sofka.stepdefinition;

import co.com.sofka.model.ProductModel;
import co.com.sofka.model.PurchaseWithoutLogFormModel;
import co.com.sofka.page.*;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.Map;

import static co.com.sofka.stepdefinition.constans.constans.ASSERTION_MESSAGE;
import static co.com.sofka.utils.util.*;


public class CompletePurchaseSD extends WebSetup {

    ZonaFitMainPage zonaFitMainPage;
    ZonaFitSearchProductPage zonaFitSearchProductPage;
    ZonaFitProductPage zonaFitProductPage;
    ZonaFitCarPage zonaFitCarPage;
    ZonaFitCheckOut zonaFitCheckOut;
    ZonaFitPaymentPage zonaFitPaymentPage;

    ProductModel productModel;
    PurchaseWithoutLogFormModel purchaseWithoutLogFormModel;


    @Given("the user is in the webpage does not login and goes to the products module")
    public void theUserIsInTheWebpageDoesNotLoginAndGoesToTheProductsModule() {
        try {
            generalSetUp(1);
            zonaFitMainPage = new ZonaFitMainPage(driver);
            zonaFitMainPage.redirectToProducts();
            zonaFitMainPage.waitSeconds(2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDriver();
        }
    }

    @When("Search for the products, add them to the car and go to my car")
    public void searchForTheProductsAddThemToTheCarAndGoToMyCar(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        try {
            zonaFitSearchProductPage = new ZonaFitSearchProductPage(driver);
            zonaFitProductPage = new ZonaFitProductPage(driver);
            zonaFitCarPage = new ZonaFitCarPage(driver);

            List<Map<String, String>> productsData = dataTable.asMaps(String.class, String.class);

            for (Map<String, String> product : productsData) {
                productModel = extractProductData(product);
                zonaFitSearchProductPage.searchProduct(productModel.getName());
                zonaFitProductPage.SelectFlavoAddToCar();
                zonaFitProductPage.closeCarPopUp();
                zonaFitProductPage.redirectToProducts();
            }
            zonaFitSearchProductPage.redirectToCar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDriver();
        }
    }



    @When("increase the amount of objects in the car and confirm the products in the car")
    public void increaseTheAmountOfObjectsInTheCarAndConfirmTheProductsInTheCar() {

        try {
            zonaFitCarPage = new ZonaFitCarPage(driver);
            zonaFitCarPage.increaseAmountProducts();
            zonaFitCarPage.waitSeconds(2);
            zonaFitCarPage.confirmCar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDriver();
        }
    }

    @When("fill the fields in the car with correct information and confirm the payment method")
    public void fillTheFieldsInTheCarWithCorrectInformationAndConfirmThePaymentMethod(io.cucumber.datatable.DataTable dataTable) {
        try {
            zonaFitCheckOut = new ZonaFitCheckOut(driver);

            List<Map<String, String>> usersInformation = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> userInformation : usersInformation) {

                purchaseWithoutLogFormModel = extractUserInfo(userInformation);

                zonaFitCheckOut.fillForm(purchaseWithoutLogFormModel);
                zonaFitCheckOut.chooseDebitCreditCardpayment();
                zonaFitCheckOut.confirmTermsConditions();
                zonaFitCheckOut.placeOrder();
                zonaFitCheckOut.waitSeconds(3);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDriver();
        }
    }

    @When("fill the payment information and confirm them")
    public void fillThePaymentInformationAndConfirmThem() {
        try {
            zonaFitPaymentPage = new ZonaFitPaymentPage(driver);
            Assertions.assertEquals(ASSERTION_MESSAGE,zonaFitPaymentPage.conseguirTextoAssertion());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDriver();
        }
    }

    @Then("it should be redirected to another page with a successful purchase")
    public void itShouldBeRedirectedToAnotherPageWithASuccessfulPurchase() {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDriver();
        }
    }

    @Then("it should get a confirmation email")
    public void itShouldGetAConfirmationEmail() {

        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDriver();
        }
    }
}
