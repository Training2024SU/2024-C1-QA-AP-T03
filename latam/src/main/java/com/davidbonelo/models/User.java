package com.davidbonelo.models;

import com.davidbonelo.models.enums.Gender;
import net.datafaker.Faker;
import net.datafaker.providers.base.Options;

import java.time.LocalDate;

public class User {
    private String id;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String password;

    public User() {
    }

    public User(String id, String name, String lastName, Gender gender, LocalDate birthDate,
                String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public static User createFakeUser() {
        Faker faker = new Faker();
        Options opt = faker.options();
        User user = new User();
        user.setId(faker.numerify("#########"));
        user.setName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setGender(opt.option(Gender.class));
        user.setBirthDate(faker.date().birthdayLocalDate(18, 99));
        user.setPhone(faker.numerify("##########"));
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(8, 14, true, true, true));
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
