package model;

public class Email implements ContactData {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email: " + email;
    }
}
