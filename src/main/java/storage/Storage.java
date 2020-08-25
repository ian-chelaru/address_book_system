package storage;

import model.AddressBook;

import java.io.*;
import java.util.Optional;

public class Storage {
    private static String path = "C:\\Dev\\workspace\\address_book_system\\src\\main\\resources\\adressbook.ser";

    public static void store(AddressBook addressBook) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(addressBook);
            out.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Optional<AddressBook> load() {
        AddressBook addressBook = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            addressBook = (AddressBook) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.of(addressBook);
    }
}
