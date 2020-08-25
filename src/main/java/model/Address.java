package model;

public class Address implements ContactData {
    private String city;
    private String street;
    private String number;

    public Address(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address: " +
                "str. " + street +
                ", nr. " + number +
                ", " + city;
    }
}
