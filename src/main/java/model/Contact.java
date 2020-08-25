package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contact implements Serializable {
    private String name;
    private List<ContactData> data;

    public Contact() {
        data = new ArrayList<>();
    }

    public Contact(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addContactData(ContactData contactData)
    {
        data.add(contactData);
    }

    @Override
    public String toString() {
        return name + " contact=" + data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
