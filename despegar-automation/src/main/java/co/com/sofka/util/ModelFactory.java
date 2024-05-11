package co.com.sofka.util;


import co.com.sofka.model.ExitoAddressModel;
import co.com.sofka.model.ExitoUserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelFactory {
    public static List<ExitoUserModel> mapDataTableToUserModels(List<Map<String, String>> dataTable) {
        List<ExitoUserModel> users = new ArrayList<>();
        for (Map<String, String> row : dataTable) {
            String idNumber = row.get("idNumber");
            String email = row.get("email");
            String name = row.get("name");
            String lastName = row.get("lastname");
            String phoneNumber = row.get("phoneNumber");
            ExitoUserModel user = new ExitoUserModel(idNumber, email, name, lastName, phoneNumber);
            users.add(user);
        }

        return users;
    }

    public static List<ExitoAddressModel> mapDataTableToAddressModels(List<Map<String, String>> dataTable) {
        List<ExitoAddressModel> addressModels = new ArrayList<>();
        for (Map<String, String> row : dataTable) {
            String number = row.get("number");
            String neighborhood = row.get("neighborhood");
            String building = row.get("building");
            String mainAddress = row.get("mainAddress");
            ExitoAddressModel exitoAddressModel = new ExitoAddressModel(number, neighborhood, building, mainAddress);
            addressModels.add(exitoAddressModel);
        }
        return addressModels;
    }
}
