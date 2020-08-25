package model;

public class Phone implements ContactData {
    private String phone;

    public Phone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Phone: " + phone;
    }
}
