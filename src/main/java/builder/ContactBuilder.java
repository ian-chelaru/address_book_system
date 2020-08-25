package builder;

import model.Address;
import model.Contact;
import model.Email;
import model.Phone;

public class ContactBuilder {
    private Contact contact;

    public ContactBuilder(String contactName) {
        this.contact = new Contact(contactName);
    }

    public static ContactBuilder createContact(String contactName)
    {
        return new ContactBuilder(contactName);
    }

    public ContactBuilder addEmail(String email)
    {
        Email emailObject = new Email(email);
        this.contact.addContactData(emailObject);
        return this;
    }

    public ContactBuilder addPhone(String phone)
    {
        Phone phoneObject = new Phone(phone);
        this.contact.addContactData(phoneObject);
        return this;
    }

    public ContactBuilder addAddress(String city, String street, String number)
    {
        Address address = new Address(city, street, number);
        this.contact.addContactData(address);
        return this;
    }

    public Contact build() {
        return contact;
    }
}
