package main.java.phones;

import java.util.Map;

public interface Contacts {
    void addContact(String number, String phoneNumber, String firstName, String lastName);

    void getFirstContact();

    void getLastContact();
}
