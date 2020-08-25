import builder.ContactBuilder;
import controller.Controller;
import exception.DuplicateContactException;
import model.AddressBook;
import model.Contact;
import storage.Storage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        AddressBook addressBook = populateAddressBook();
        AddressBook addressBook = Storage.load().orElseThrow(RuntimeException::new);
        Controller controller = new Controller(addressBook);
        controller.start();
    }

    private static AddressBook populateAddressBook() {
        AddressBook addressBook = new AddressBook();
        Contact contact1 = ContactBuilder.createContact("John").addEmail("john@yahoo.com").addPhone("1234").build();
        Contact contact2 = ContactBuilder.createContact("Mary").addEmail("mary@gmail.com").addAddress("Cluj-Napoca", "Paris", "14").build();
        Contact contact3 = ContactBuilder.createContact("Fred").addEmail("fred@yahoo.com").addPhone("1111")
                .addAddress("Cluj-Napoca", "Donath", "5A").build();
        try {
            addressBook.add(contact1);
            addressBook.add(contact2);
            addressBook.add(contact3);
        } catch (DuplicateContactException e) {
            e.printStackTrace();
        }
        return addressBook;
    }
}
