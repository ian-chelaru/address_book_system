package model;

import exception.ContactNotFoundException;
import exception.DuplicateContactException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AddressBook implements Serializable {
    private Set<Contact> contacts;

    public AddressBook() {
        contacts = new HashSet<>();
    }

    public void add(Contact contact) throws DuplicateContactException {
        if (contacts.contains(contact)) {
            throw new DuplicateContactException();
        }
        contacts.add(contact);
    }

    public void add(String name) throws DuplicateContactException {
        Contact newContact = new Contact(name);
        if (contacts.contains(newContact)) {
            throw new DuplicateContactException();
        }
        contacts.add(newContact);
    }

    public boolean delete(String name) {
        return contacts.remove(new Contact(name));
    }

    public Contact find(String name) throws ContactNotFoundException {
        for (Contact contact : contacts) {
            if (name.equals(contact.getName())) {
                return contact;
            }
        }
        throw new ContactNotFoundException();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Contact contact: this.contacts)
        {
            s.append(contact.toString()).append("\n");
        }
        return s.toString();
    }
}
