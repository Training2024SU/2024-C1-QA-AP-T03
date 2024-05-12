package co.com.sofka.stepdefinitions;

import co.com.sofka.pages.exitopages.*;
import co.com.sofka.setup.ExitoWebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class PurchaseASingleProductByCategoryStepDefinitions extends ExitoWebSetUp {
    HomePage homePage;
    CellPhonesCategoryPage cellPhonesCategoryPage;
    ProductDetails productDetails;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("adds to cart by category {string} a cell phone {string} selecting {int} units")
    public void addsToCartByCategoryACellPhoneSelectingUnits(String categoryName, String cellPhoneName, Integer unitsQuantity) {

        try {
            homePage = new HomePage(driver);
            cellPhonesCategoryPage = new CellPhonesCategoryPage(driver);
            productDetails = new ProductDetails(driver);
            homePage.selectCategories(categoryName);
            cellPhonesCategoryPage.selectCellPhones(cellPhoneName);
            productDetails.addProducts(unitsQuantity);
            productDetails.goToCart();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }


    }

    @When("goes to finalize the purchase with email {string} name {string} last name {string} id {string} number {string} cell phone {string}")
    public void goesToFinalizeThePurchaseWithEmailNameLastNameIdNumberCellPhone(String email, String name, String lastName, String idType, String idNumber, String cellPhoneNumber) {

        try {
            cartPage = new CartPage(driver);
            checkoutPage = new CheckoutPage(driver);
            cartPage.ClickPayButton();
            cartPage.typeEmail(email);
            checkoutPage.fillCheckoutForm(name, lastName, idNumber, cellPhoneNumber);
            //checkoutPage.fillDeliveryForm(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }


    }

    @When("fills the delivery form state {string} city {string} addres type {string} address numnber {string} {string} {string} neighborhood {string} receives {string}")
    public void fillsTheDeliveryFormStateCityAddresTypeAddressNumnberNeighborhoodReceives(String state, String city, String addresType, String num1, String num2, String num3, String neighborhood, String receiver) {

        try {
            checkoutPage.fillDeliveryForm(state, city, addresType, num1, num2, num3, neighborhood, receiver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
            Assertions.fail();
        }


    }

    @Then("should see a button with name Finalizar compra {string}")
    public void shouldSeeAButtonWithNameFinalizarCompra(String expectedMessage) {
        try {
            String actualMessage = checkoutPage.getText();
            Assertions.assertTrue(actualMessage.contains(expectedMessage));
            System.out.println("Actual message: " + actualMessage);
            System.out.println("Expected message: " + expectedMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDriver();
        }
    }


}
