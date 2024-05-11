package co.com.sofka.utils;

import co.com.sofka.model.*;

import java.util.List;
import java.util.Map;

public class util {

    public static ProductModel extractProductData(Map<String, String> product) {
        ProductModel productModel = new ProductModel();
        productModel.setName(product.get("product"));
        productModel.setAmount(Integer.parseInt(product.get("amount")));
        return productModel;
    }

    public static PurchaseWithoutLogFormModel extractUserInfo(Map<String, String> product) {
        PurchaseWithoutLogFormModel purchaseWithoutLogFormModel = new PurchaseWithoutLogFormModel();

        purchaseWithoutLogFormModel.setIdNumber(product.get("idNumber"));
        purchaseWithoutLogFormModel.setEmail(product.get("email"));
        purchaseWithoutLogFormModel.setName(product.get("name"));
        purchaseWithoutLogFormModel.setLastName(product.get("lastName"));
        purchaseWithoutLogFormModel.setState(product.get("state"));
        purchaseWithoutLogFormModel.setCity(product.get("city"));
        purchaseWithoutLogFormModel.setAddress(product.get("address"));
        purchaseWithoutLogFormModel.setAddress2(product.get("address2"));
        purchaseWithoutLogFormModel.setPhoneNumber(product.get("phoneNumber"));

        return purchaseWithoutLogFormModel;
    }

}
