package co.com.sofka.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FormularioModel {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private Date birth;
    private ArrayList<String> subjects  = new ArrayList<String>();

    private String hobbies;
    private String address;
    private String state;

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private static SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(String element) {
        this.subjects.add(element);
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
