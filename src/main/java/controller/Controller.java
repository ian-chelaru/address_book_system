package controller;

import exception.ContactNotFoundException;
import exception.DuplicateContactException;
import model.AddressBook;
import model.Contact;
import storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private AddressBook addressBook;

    public Controller() {
        this.addressBook = new AddressBook();
    }

    public Controller(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    private void displayMenu() {
        System.out.println("1. Add contact");
        System.out.println("2. Delete contact");
        System.out.println("3. Find contact");
        System.out.println("4. Display all contacts");
        System.out.println("0. Exit");
        System.out.println("Enter command: ");
    }

    public void start() throws IOException {
        boolean run = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (run) {
            displayMenu();
            String command = reader.readLine();
            if ("0".equals(command)) {
                run = false;
                Storage.store(addressBook);
            }
            else if ("1".equals(command))
            {
                System.out.println("Give name: ");
                String name = reader.readLine();
                try {
                    addressBook.add(name);
                } catch (DuplicateContactException e) {
                    System.out.println("Duplicate contact");
                }
            }
            else if ("2".equals(command))
            {
                System.out.println("Give name: ");
                String name = reader.readLine();
                addressBook.delete(name);
            }
            else if ("3".equals(command))
            {
                System.out.println("Give name: ");
                String name = reader.readLine();
                try {
                    Contact contact = addressBook.find(name);
                    System.out.println(contact);
                } catch (ContactNotFoundException e) {
                    System.out.println("Contact not found");
                }
            }
            else if ("4".equals(command))
            {
                System.out.println(addressBook);
            }
        }
    }
}
