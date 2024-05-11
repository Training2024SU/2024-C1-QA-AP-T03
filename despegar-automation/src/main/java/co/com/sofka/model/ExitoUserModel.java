package co.com.sofka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExitoUserModel {
    private String idNumber; // 10
    private String email;
    private String name;
    private String lastName;
    private String phoneNumber; // starts with 3

    @Override
    public String toString() {
        return "ExitoUserModel{" +
                "idNumber='" + idNumber + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
