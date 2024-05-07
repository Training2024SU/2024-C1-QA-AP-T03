package co.com.sofka.model.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CardModel {
    private Integer cardNumber;
    private String ownerName;
    private Integer expiration;
    private Integer secCode;
    private Integer ownerId;
}
