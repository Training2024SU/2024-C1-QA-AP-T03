package co.com.sofka.model.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFormModel {
    private String name;
    private String lastName;
    private String country;
    private String idNumber;
    private Integer day;
    private Integer month;
    private Integer year;
    private String gender;
    private String address;
}
