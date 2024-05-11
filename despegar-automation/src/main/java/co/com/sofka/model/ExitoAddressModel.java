package co.com.sofka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExitoAddressModel {
    private String number;
    private String neighborhood;
    private String building;
    private String mainAddress;
}
