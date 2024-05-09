package co.com.demo.util;

import co.com.demo.model.Passenger;


public class util {

    public static Passenger createPassenger() {
        Passenger passenger = new Passenger();
        passenger.setName("Daniel");
        passenger.setLastName("Morales");
        passenger.setDateOfBirth("17-05-1997");
        passenger.setIdentification("123235235");
        passenger.setPhoneNumber("3245331355");
        passenger.setEmail("dm345@gmail.com");

        return passenger;
    }

    public static Passenger createadditionalPassenger() {
        Passenger passenger = new Passenger();
        passenger.setName("Daniel");
        passenger.setLastName("Morales");
        passenger.setDateOfBirth("17-05-1997");
        passenger.setIdentification("123235235");

        return passenger;
    }
}
